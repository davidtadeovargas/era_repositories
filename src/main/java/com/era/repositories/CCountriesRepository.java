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
import org.hibernate.Session;

/**
 *
 * @author PC
 */
public class CCountriesRepository extends Repository {
    
    protected CCountriesRepository(){
        super(CCountry.class);
    }
    
    @Override
    public List<?> getAllByPageWithSearchFilter(final String search, final int pageNumber, int pageSize) throws Exception {
        
        //Open database
        openDatabase();
        
        final Session Session = HibernateUtil.getSingleton().getSession();
        
        String hql = "FROM CCountry WHERE code LIKE:code OR description LIKE:description OR Agrupaciones LIKE:Agrupaciones";
        Query query = Session.createQuery(hql);
        query.setParameter("code", "%" + search + "%");
        query.setParameter("description", "%" + search + "%");
        query.setParameter("Agrupaciones", "%" + search + "%");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);        
        List<?> records = query.list();
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return records;
    }
    
    @Override
    public List<CCountry> getAllByPage(final int pageNumber) throws Exception {
        final List<CCountry> records = (List<CCountry>) this.getAllByPage(pageNumber,50);
        return records;
    }
    
    final public CCountry getCountryByCode(final String code) throws Exception {
        
        //Open database
        openDatabase();        
        
        String hql = "FROM CCountry where code = :code";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("code", code);
        CCountry CCountry = query.list().size() > 0 ? (CCountry)query.list().get(0):null;
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return CCountry;
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