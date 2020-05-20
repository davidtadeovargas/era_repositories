/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Coin;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class CoinsRepository extends Repository {
    
    protected CoinsRepository(){
        super(Coin.class);
    }
    
    final public Coin getByCoin(final String mon) throws Exception {
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String hql = "FROM Coin where mon = :mon";
        Query query = session.createQuery(hql);
        query.setParameter("mon", "mon");
        Coin Coin = query.list().size() > 0 ? (Coin)query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Coin;
    }
}