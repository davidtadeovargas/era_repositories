/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Cxc;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
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
        HibernateUtil.getSingleton().openSession(ClassEntity);
        HibernateUtil.getSingleton().getSession().beginTransaction();
        
        String hql = "FROM Cxc WHERE norefer = :norefer";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("norefer", norefer);
        List<Cxc> list = query.list();
        
        //Close database
        HibernateUtil.getSingleton().getSession().getTransaction().commit();
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return list.size()>0?list.get(0):null;
    }
    
    
    final public Cxc getCXC(final String norefer,
                            final String noser,
                            final String id_venta,
                            final String empre) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        HibernateUtil.getSingleton().getSession().beginTransaction();
        
        String hql = "FROM Cxc WHERE norefer = :norefer AND noser = :noser AND id_venta = :id_venta AND empre = :empre";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("norefer", norefer);
        query.setParameter("noser", noser);
        query.setParameter("id_venta", id_venta);
        query.setParameter("empre", empre);
        List<Cxc> list = query.list();
        
        //Close database
        HibernateUtil.getSingleton().getSession().getTransaction().commit();
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return list.size()>0?list.get(0):null;
    }
    
    final public void deleteByConfg(final String norefer) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        HibernateUtil.getSingleton().getSession().beginTransaction();
        
        //Save
        final SQLQuery SQLQuery = HibernateUtil.getSingleton().getSession().createSQLQuery("DELETE FROM Cxc WHERE norefer = :norefer");
        SQLQuery.setParameter("norefer", norefer);
        SQLQuery.executeUpdate();
        
        //Close database
        HibernateUtil.getSingleton().getSession().getTransaction().commit();
        HibernateUtil.getSingleton().closeSession();
    }
    
    final public void cancelaCXC(final int id) throws Exception{
        
        final Cxc Cxc = (Cxc) this.getByID(id);        
        Cxc.setEstado("CA");        
        this.update(Cxc);
    }
    
    @Override
    final public List<Cxc> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<Cxc> items = (List<Cxc>) this.getAllLike(likes, search);
        
        return items;
    }
}
