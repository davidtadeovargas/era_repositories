/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.CCodigopostal;
import com.era.repositories.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class CCodigoPostalRepository extends Repository {
    
    protected CCodigoPostalRepository(){
        super(CCodigopostal.class);
    }
    
    public List<CCodigopostal> getAllByPage(final int pageNumber) throws Exception {
        
        //Some tables are from dbempresas and when trying to access them need to change the connection
        changeConnectionQuestion();
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();        
        
        final int pageSize = 50;
        
        String hql = "FROM CCodigopostal";
        Query query = session.createQuery(hql);
        query.setFirstResult(pageNumber - 1);
        query.setMaxResults(pageSize);
        List<CCodigopostal> cps = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return cps;
    }
}