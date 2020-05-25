/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Comprs;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class ComprsRepository extends Repository {

    public ComprsRepository() {
        super(Comprs.class);
    }
    
    final public int getTotalComprsByProv(final String prov) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "select count(distinct prov) from Comprs WHERE prov = :prov";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("prov", prov);
        Iterator count = query.iterate();
        final int count_ = (int) count.next();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return count_;
    }
    
    
    final public Comprs getByProvAndNoDoc(final String prov, final String nodoc) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Comprs where prov = :prov AND nodoc = :nodoc";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("prov", prov);
        query.setParameter("nodoc", nodoc);
        Comprs Comprs = query.list().size() > 0 ? (Comprs)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return Comprs;
    }
    
    final public List<Comprs> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("CODCOMP");
        likes.add("NODOC");
        likes.add("NOM");
        likes.add("TOT");
        likes.add("FALT");
        likes.add("FDOC");
        likes.add("FMOD");
        likes.add("ESTADO");
        likes.add("ESTAC");
        likes.add("MOTIV");        
        
        final List<Comprs> comprs = (List<Comprs>) this.getAllLike(likes, search);
        
        return comprs;
    }
    
    
    final public List<Comprs> getAllByProv(final String prov) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Comprs where prov = :prov";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("prov", prov);
        List<Comprs> Comprs = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return Comprs;
    }
}
