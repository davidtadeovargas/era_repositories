/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Tax;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 *
 * @author PC
 */
public class TaxesRepository extends Repository {
    
    protected TaxesRepository(){
        super(Tax.class);
    }
    
    
    final public Tax getByCodeImpue(final String codimpue) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Tax WHERE codimpue = :codimpue";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);        
        List<Tax> list = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return list.size()>0?list.get(0):null;
    }
    
    final public void deleteByCodimpue(final String codimpue) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        //Save
        final SQLQuery SQLQuery = HibernateUtil.getSingleton().getSession().createSQLQuery("DELETE FROM Tax WHERE codimpue = :codimpue");
        SQLQuery.setParameter("codimpue", codimpue);
        SQLQuery.executeUpdate();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
    }
    
    final public List<Tax> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("codimpue");
        likes.add("impueval");
        likes.add("falt");
        likes.add("fmod");
        
        final List<Tax> taxes = (List<Tax>) this.getAllLike(likes, search);
        
        return taxes;
    }
}