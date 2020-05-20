/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.CCountry;
import com.era.repositories.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class CCountriesRepository extends Repository {
    
    protected CCountriesRepository(){
        super(CCountry.class);
    }
    
    public List<CCountry> getAllByPage(final int pageNumber) throws Exception {
        final List<CCountry> records = (List<CCountry>) this.getAllByPage(pageNumber,50);
        return records;
    }
    
    final public CCountry getCountryByCode(final String code) throws Exception {
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String hql = "FROM CCountry where code = :code";
        Query query = session.createQuery(hql);
        query.setParameter("code", code);
        CCountry CCountry = query.list().size() > 0 ? (CCountry)query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return CCountry;
    }
}