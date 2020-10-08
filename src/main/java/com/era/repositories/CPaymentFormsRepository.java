package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.CPaymentForm;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class CPaymentFormsRepository extends Repository {

    public CPaymentFormsRepository() {
        super(CPaymentForm.class);
    }
   
    final public CPaymentForm getCashForm() throws Exception {
        
        //Open database
        openDatabase();        
                
        String hql = "FROM CPaymentForm WHERE description = :description";
        final org.hibernate.classic.Session Session = HibernateUtil.getSingleton().getSession();
        Query query = Session.createQuery(hql);
        query.setParameter("description", "Efectivo");
        CPaymentForm CPaymentForm = query.list().size() > 0 ? (CPaymentForm)query.list().get(0):null;
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return CPaymentForm;
    }
    
    @Override
    public List<?> getAllBySearchFilter(final String search) throws Exception {
        
        //Open database
        openDatabase();       
        
        final Session Session = HibernateUtil.getSingleton().getSession();
        
        String hql = "FROM CPaymentForm WHERE c_FormaPago LIKE:c_FormaPago OR description LIKE:description";
        Query query = Session.createQuery(hql);
        query.setParameter("c_FormaPago", "%" + search + "%");
        query.setParameter("description", "%" + search + "%");        
        List<?> records = query.list();
        
        //Close database
        closeDatabase();
        
        //Return the result model
        return records;
    }
    
   @Override
   final public List<CPaymentForm> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<CPaymentForm> records = (List<CPaymentForm>) this.getAllLike(likes, search);
       
       return records;
   }

}