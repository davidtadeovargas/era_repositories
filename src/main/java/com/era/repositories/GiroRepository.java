/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Giro;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class GiroRepository extends Repository {

    public GiroRepository() {
        super(Giro.class);
    }
 
    final public Giro getByGiro(final String gir) throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "FROM Giro where gir = :gir";
        Query query = session.createQuery(hql);
        query.setParameter("gir", gir);
        Giro Giro = query.list().size() > 0 ? (Giro)query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Giro;
    }
}
