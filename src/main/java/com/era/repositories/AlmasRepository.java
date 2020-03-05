/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Almas;
import com.era.repositories.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class AlmasRepository extends Repository {

    public AlmasRepository() {
        super(Almas.class);
    }
    
    final public Almas getByAlma(final String alma) throws Exception{
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "FROM Almas WHERE alma = :alma";
        Query query = session.createQuery(hql);
        query.setParameter("alma", alma);
        List<Almas> list = query.list();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return list.size()>0?list.get(0):null;
    }
    
    final public void deleteByAlma(final String alma) throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "FROM Almas WHERE almca = :alma";
        Query query = session.createQuery(hql);
        query.setParameter("alma", alma);
        Almas Almas = query.list().size() > 0 ? (Almas) query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        this.delete(Almas);
    }    
}
