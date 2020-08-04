/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.CCodigopostal;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author PC
 */
public class CCodigoPostalRepository extends Repository {
 
    protected CCodigoPostalRepository(){
        super(CCodigopostal.class);
    }
    
    @Override
    public List<?> getAllByPageWithSearchFilter(final String search, final int pageNumber, int pageSize) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);       
        
        final Session Session = HibernateUtil.getSingleton().getSession();
        
        String hql = "FROM CCodigopostal WHERE cp LIKE:cp OR estate LIKE:estate OR municipio LIKE:municipio";
        Query query = Session.createQuery(hql);
        query.setParameter("cp", "%" + search + "%");
        query.setParameter("estate", "%" + search + "%");
        query.setParameter("municipio", "%" + search + "%");
        
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);        
        
        List<?> records = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return records;
    }
        
    @Override
    public List<CCodigopostal> getAllByPage(final int pageNumber) throws Exception {
        final List<CCodigopostal> records = (List<CCodigopostal>) this.getAllByPage(pageNumber,50);
        return records;
    }
    
    final public CCodigopostal getByPostalCode(final String cp) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM CCodigopostal where cp = :cp";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("cp", cp);
        CCodigopostal CCodigopostal = query.list().size() > 0 ? (CCodigopostal)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return CCodigopostal;
    }
        
    final public boolean existsExpeditionPlace(final String cp) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM CCodigopostal where cp = :cp";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("cp", cp);
        final boolean result = query.list().size() > 0;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
               
        return result;
    }
    
    public List<CCodigopostal> getAllByPageExpeditionPlace(final int pageNumber) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        final int pageSize = 50;
        
        String hql = "FROM CCodigopostal GROUP BY estate";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setFirstResult(pageNumber - 1);
        query.setMaxResults(pageSize);
        List<CCodigopostal> records = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return records;
    }
    
    @Override
    final public List<CCodigopostal> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<CCodigopostal> items = (List<CCodigopostal>) this.getAllLike(likes, search);
        
        return items;
    }
}
