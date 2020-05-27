package com.era.repositories;

import com.era.models.Consec;
import com.era.repositories.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;

public class ConsecsRepository extends Repository {

   public ConsecsRepository() {
        super(Consec.class);
    }
   
   final public Consec updateConsecCustomer(final String serie) throws Exception {
        
        Consec Consec = this.getCustomerConsec(serie);
        Consec.setConsec(Consec.getConsec() + 1);
        
        this.update(Consec);
        
        return Consec;
    }
    
    final public List<Consec> getCustomersConsec() throws Exception {        
        return getByType("EMP");        
    }
        
    final public List<Consec> getSalesConsec() throws Exception {        
        return getByType("FAC");        
    }
    
    final public List<Consec> getRemisionsConsec() throws Exception {        
        return getByType("REM");        
    }
    
    final public List<Consec> getTicketsConsec() throws Exception {        
        return getByType("TIK");        
    }
    
    final public List<Consec> getCotsConsec() throws Exception {        
        return getByType("COT");        
    }
    
    final public List<Consec> getCompsConsec() throws Exception {        
        return getByType("COM");        
    }
    
    final public List<Consec> getCreditNotsConsec() throws Exception {        
        return getByType("NOT");        
    }
    
    private Consec getCustomerConsec(final String serie) throws Exception {
        return getConsec(serie, "EMP");
    }
    
    private Consec getSalesConsec(final String serie) throws Exception {        
        return getConsec(serie, "FAC");
    }
    
    private Consec getRemisionsConsec(final String serie) throws Exception {        
        return getConsec(serie, "REM");
    }
    
    private Consec getTicketsConsec(final String serie) throws Exception {        
        return getConsec(serie, "TIK");
    }
    
    private Consec getCotsConsec(final String serie) throws Exception {        
        return getConsec(serie, "COT");
    }
    
    private Consec getComConsec(final String serie) throws Exception {        
        return getConsec(serie, "COM");
    }
    
    private Consec getCreditNotesConsec(final String serie) throws Exception {        
        return getConsec(serie, "NOT");
    }
    
    private Consec getConsec(final String serie, final String type) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Consec where type = :type AND serie = :serie";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("type", type);
        query.setParameter("serie", serie);
        Consec Consec = query.list().size() > 0 ? (Consec)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return Consec;
    }
    
    private List<Consec> getByType(final String type) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Consec where type = :type";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("type", type);
        final List<Consec> consecs = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return consecs;
    }
}