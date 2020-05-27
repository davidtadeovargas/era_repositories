package com.era.repositories;

import com.era.models.Tips;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;

public class TipssRepository extends Repository {

   public TipssRepository() {
        super(Tips.class);
    }
   
   final public Tips getBytType(final String type) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        HibernateUtil.getSingleton().getSession().beginTransaction();
        
        String hql = "FROM Tips where cod = :type";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("cod", type);
        Tips Tips = query.list().size() > 0 ? (Tips)query.list().get(0):null;
        
        //Close database
        HibernateUtil.getSingleton().getSession().getTransaction().commit();
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return Tips;
    }
    
    final public Tips getFacType() throws Exception {
        return getBytType("FAC");
    }
    
    final public Tips getNotCType() throws Exception {
        return getBytType("NOTC");
    }
    
    final public Tips getTickType() throws Exception {
        return getBytType("TIK");
    }
    
    final public Tips getRemType() throws Exception {
        return getBytType("REM");
    }
}