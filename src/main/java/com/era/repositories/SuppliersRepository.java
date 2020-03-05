/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.repositories.utils.HibernateUtil;
import com.era.models.Supplier;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class SuppliersRepository extends Repository {
    
    protected SuppliersRepository(){
        super(Supplier.class);
    }
    
    final public Supplier getByProvCode(final String code) throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        
        String hql = "FROM Supplier where prov = :code";
        Query query = session.createQuery(hql);
        query.setParameter("code", code);
        Supplier Supplier = query.list().size() > 0 ? (Supplier)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Supplier;
    }
    
    final public Supplier getByRFC(final String rfc, final String nom) throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        
        String hql = "FROM Supplier where rfc = :rfc AND nom = :nom";
        Query query = session.createQuery(hql);
        query.setParameter("rfc", rfc);
        query.setParameter("nom", nom);
        Supplier Supplier = query.list().size() > 0 ? (Supplier)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Supplier;
    }
    
    final public List<Supplier> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("nom");        
        likes.add("tel");
        likes.add("calle");
        likes.add("col");
        likes.add("cp");
        likes.add("ciu");
        likes.add("pais");
        likes.add("estad");
        likes.add("rfc");
        likes.add("co1");
        likes.add("co2");
        likes.add("co3");
        likes.add("pagweb1");
        likes.add("pagweb2");
        likes.add("pagweb2");
        likes.add("observ");
        
        final List<Supplier> suppliers = (List<Supplier>) this.getAllLike(likes, search);
        
        return suppliers;
    }
}