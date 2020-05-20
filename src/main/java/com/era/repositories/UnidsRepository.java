
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Unid;
import com.era.repositories.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class UnidsRepository extends Repository {
    
    protected UnidsRepository(){
        super(Unid.class);
    }
    
    final public List<Unid> getAllClaveSAT() throws Exception {
        
        //Open database
        this.openSession();
        
        String hql = "FROM Unid where claveSAT != '' AND claveSAT is not null";
        Query query = session.createQuery(hql);        
        List<Unid> Unids = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Unids;
    }
}