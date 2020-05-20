/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Domentcli;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class DomentcliRepository extends Repository {

    public DomentcliRepository() {
        super(Domentcli.class);
    }
    
    
    final public Domentcli getByCustomer(final String codemp) throws Exception {
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String hql = "FROM Domentcli where codemp = :codemp";
        Query query = session.createQuery(hql);
        query.setParameter("codemp", codemp);
        Domentcli Domentcli = query.list().size() > 0 ? (Domentcli)query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Domentcli;
    }
}
