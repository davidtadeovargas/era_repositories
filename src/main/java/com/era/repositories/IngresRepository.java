/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Ingres;
import com.era.repositories.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class IngresRepository extends Repository {

    public IngresRepository() {
        super(Ingres.class);
    }
    
    final public List<Ingres> geAllByNoserAndNoRefer(final String norefer,final String noser) throws Exception{
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String hql = "FROM Ingres WHERE norefer = :norefer AND noser = :noser";
        Query query = session.createQuery(hql);
        query.setParameter("norefer", norefer);
        query.setParameter("noser", noser);
        List<Ingres> list = query.list();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return list;
    }
}
