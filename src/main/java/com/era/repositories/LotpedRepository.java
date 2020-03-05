/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Lotped;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class LotpedRepository extends Repository {

    public LotpedRepository() {
        super(Lotped.class);
    }
 
    final public Lotped getByLotAndPed(final String lot, final String pedimen) throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        
        String hql = "FROM Lotped where lot = :lot AND configuration = :configuration AND pedimen = :pedimen";
        Query query = session.createQuery(hql);
        query.setParameter("lot", lot);
        query.setParameter("pedimen", pedimen);
        Lotped Lotped = query.list().size() > 0 ? (Lotped)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Lotped;
    }
}
