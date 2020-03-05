/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.repositories.utils.HibernateUtil;
import com.era.models.Country;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class CountriesRepository extends Repository {
    
    protected CountriesRepository(){
        super(Country.class);
    }
    
    final public Country getCountryByCode(final String countryCode) throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();        
        
        String hql = "FROM Country where countryCode = :countryCode";
        Query query = session.createQuery(hql);
        query.setParameter("countryCode", countryCode);
        Country Country = query.list().size() > 0 ? (Country)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Country;
    }
}