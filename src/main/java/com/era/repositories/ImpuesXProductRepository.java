/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.ImpuesXProduct;
import com.era.repositories.utils.HibernateUtil;
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
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "FROM ImpuesXProduct WHERE produ = :produ";
        Query query = session.createQuery(hql);
        query.setParameter("produ", produ);
        List<ImpuesXProduct> list = query.list();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return list;
    }
}
