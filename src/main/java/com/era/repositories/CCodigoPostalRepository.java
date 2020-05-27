/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.CCodigopostal;
import com.era.repositories.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class CCodigoPostalRepository extends Repository {
 
    protected CCodigoPostalRepository(){
        super(CCodigopostal.class);
    }
    
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
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return CCodigopostal;
    }
        
    final public boolean existsExpeditionPlace(final String estate) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM CCodigopostal where estate = :estate";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("estate", estate);
        query.setFirstResult(0);
        query.setMaxResults(5);
        final boolean result = query.list().size() > 0;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
               
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
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return records;
    }
}
