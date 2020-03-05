/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Cxc;
import com.era.repositories.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 *
 * @author PC
 */
public class CxcRepository extends Repository {

    public CxcRepository() {
        super(Cxc.class);
    }
    
    final public Cxc getByNorefer(final String norefer) throws Exception{
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "FROM Cxc WHERE norefer = :norefer";
        Query query = session.createQuery(hql);
        query.setParameter("norefer", norefer);
        List<Cxc> list = query.list();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return list.size()>0?list.get(0):null;
    }
    
    
    final public Cxc getCXC(final String norefer,
                            final String noser,
                            final String id_venta,
                            final String empre) throws Exception{
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "FROM Cxc WHERE norefer = :norefer AND noser = :noser AND id_venta = :id_venta AND empre = :empre";
        Query query = session.createQuery(hql);
        query.setParameter("norefer", norefer);
        query.setParameter("noser", noser);
        query.setParameter("id_venta", id_venta);
        query.setParameter("empre", empre);
        List<Cxc> list = query.list();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return list.size()>0?list.get(0):null;
    }
    
    final public void deleteByConfg(final String norefer) throws Exception{
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        session.beginTransaction();
        
        //Save
        final SQLQuery SQLQuery = session.createSQLQuery("DELETE FROM Cxc WHERE norefer = :norefer");
        SQLQuery.setParameter("norefer", norefer);
        SQLQuery.executeUpdate();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
    }
    
    final public void cancelaCXC(final int id) throws Exception{
        
        final Cxc Cxc = (Cxc) this.getByID(id);        
        Cxc.setEstado("CA");        
        this.update(Cxc);
    }
}
