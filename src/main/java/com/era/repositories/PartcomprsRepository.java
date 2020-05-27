/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Partcomprs;
import com.era.repositories.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class PartcomprsRepository extends Repository {

    public PartcomprsRepository() {
        super(Partcomprs.class);
    }
    
    
    final public List<Partcomprs> getAllByComp(final String codcom) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Partcomprs where codcom = :codcom";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("codcom", codcom);        
        List<Partcomprs> parts = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return parts;
    }
}
