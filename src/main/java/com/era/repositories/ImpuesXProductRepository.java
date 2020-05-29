/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.ImpuesXProduct;
import com.era.models.User;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class ImpuesXProductRepository extends Repository {

    public ImpuesXProductRepository() {
        super(ImpuesXProduct.class);
    }
 
    final public List<ImpuesXProduct> getAllByProd(final String produ) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        HibernateUtil.getSingleton().begginTransaction();        
        
        String hql = "FROM ImpuesXProduct WHERE produ = :produ";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("produ", produ);
        List<ImpuesXProduct> list = query.list();
        
        //Close database
        HibernateUtil.getSingleton().commitTransacton();
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return list;
    }
    
    @Override
    final public List<ImpuesXProduct> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<ImpuesXProduct> items = (List<ImpuesXProduct>) this.getAllLike(likes, search);
        
        return items;
    }
}
