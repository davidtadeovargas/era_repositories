package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Supplier;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class SuppliersRepository extends Repository {

    public SuppliersRepository() {
        super(Supplier.class);
    }

    @Override
    public List<?> getAllByPageWithSearchFilter(final String search, final int pageNumber, int pageSize) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);       
        
        final Session Session = HibernateUtil.getSingleton().getSession();
        
        String hql = "FROM Supplier WHERE code LIKE:code OR name LIKE:name OR rfc LIKE:rfc";
        Query query = Session.createQuery(hql);
        query.setParameter("code", "%" + search + "%");
        query.setParameter("name", "%" + search + "%");
        query.setParameter("rfc", "%" + search + "%");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);        
        List<?> records = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return records;
    }
    
    final public Supplier rfcExists(final String existRFC, final String rfcOri) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Supplier where rfc = :existRFC and rfc != :rfcOri";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("existRFC", existRFC);
        query.setParameter("rfcOri", rfcOri);
        Supplier Supplier = query.list().size() > 0 ? (Supplier)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Supplier;
    }
    
    final public Supplier rfcExists(final String RFC) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Supplier where rfc = :RFC";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("RFC", RFC);        
        Supplier Supplier = query.list().size() > 0 ? (Supplier)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Supplier;
    }
    
    @Override
    final public List<Supplier> getByLikeEncabezados(final String search) throws Exception{

        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("name");
        likes.add("falt");
        likes.add("fmod");

        final List<Supplier> records = (List<Supplier>) this.getAllLike(likes, search);

        return records;
    }

}