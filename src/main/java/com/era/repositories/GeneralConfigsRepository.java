/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.repositories.utils.HibernateUtil;
import com.era.models.GeneralConfig;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class GeneralConfigsRepository extends Repository {
    
    protected GeneralConfigsRepository(){
        super(GeneralConfig.class);
    }
    
    final public GeneralConfig getConfigCFDIi33() throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        
        String hql = "FROM GeneralConfig where casification = :casification AND configuration = :configuration";
        Query query = session.createQuery(hql);
        query.setParameter("casification", "sist");
        query.setParameter("configuration", "cfdi33");
        GeneralConfig GeneralConfig = query.list().size() > 0 ? (GeneralConfig)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return GeneralConfig;
    }
}