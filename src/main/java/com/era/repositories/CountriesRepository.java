/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.CCountry;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class CountriesRepository extends Repository {
    
    protected CountriesRepository(){
        super(CCountry.class);
    }
    
    final public CCountry getCountryByCode(final String countryCode) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Country where countryCode = :countryCode";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("countryCode", countryCode);
        CCountry Country = query.list().size() > 0 ? (CCountry)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Country;
    }
    
    @Override
    final public List<CCountry> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<CCountry> items = (List<CCountry>) this.getAllLike(likes, search);
        
        return items;
    }
}