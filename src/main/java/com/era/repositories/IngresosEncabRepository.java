/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.IngresosEncab;
import com.era.repositories.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class IngresosEncabRepository extends Repository {

    public IngresosEncabRepository() {
        super(IngresosEncab.class);
    }
    
    final public IngresosEncab getByNoserNorefer(final String noser, final String norefer) throws Exception{
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "FROM IngresosEncab WHERE noser = :noser AND norefer = :norefer";
        Query query = session.createQuery(hql);
        query.setParameter("noser", noser);
        query.setParameter("norefer", norefer);
        List<IngresosEncab> list = query.list();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return list.size()>0?list.get(0):null;
    }
}
