/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.CRegimenfiscal;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.classic.Session;

/**
 *
 * @author PC
 */
public class CRegimenFiscalRepository extends Repository {
    
    protected CRegimenFiscalRepository(){
        super(CRegimenfiscal.class);
    }
    
    @Override
    public List<?> getAllBySearchFilter(final String search) throws Exception {
        
        //Open database
        openDatabase();
        
        final Session Session = HibernateUtil.getSingleton().getSession();
        
        String hql = "FROM " + ClassEntity.getName() + " WHERE c_RegimenFiscal LIKE:c_RegimenFiscal OR description LIKE:description";
        Query query = Session.createQuery(hql);
        query.setParameter("c_RegimenFiscal", "%" + search + "%");
        query.setParameter("description", "%" + search + "%");        
        List<?> records = query.list();
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return records;
    }
    
    final public CRegimenfiscal getRegimenByCode(final String c_RegimenFiscal) throws Exception {
        
        //Open database
        openDatabase();
        
        String hql = "FROM CRegimenfiscal where c_RegimenFiscal = :c_RegimenFiscal";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);        
        query.setParameter("c_RegimenFiscal", c_RegimenFiscal);
        CRegimenfiscal CRegimenfiscal = query.list().size() > 0 ? (CRegimenfiscal)query.list().get(0):null;
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return CRegimenfiscal;
    }
    
    @Override
    final public List<CRegimenfiscal> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<CRegimenfiscal> items = (List<CRegimenfiscal>) this.getAllLike(likes, search);
        
        return items;
    }
}