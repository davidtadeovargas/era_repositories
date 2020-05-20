/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.CRegimenfiscal;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class CRegimenFiscalRepository extends Repository {
    
    protected CRegimenFiscalRepository(){
        super(CRegimenfiscal.class);
    }
    
    final public CRegimenfiscal getRegimenByCode(final String c_RegimenFiscal) throws Exception {
        
        //Open database
        this.openSession();
        
        String hql = "FROM CRegimenfiscal where c_RegimenFiscal = :c_RegimenFiscal";
        Query query = session.createQuery(hql);
        final int intc_RegimenFiscal = Integer.valueOf(c_RegimenFiscal);
        query.setParameter("c_RegimenFiscal", intc_RegimenFiscal);
        CRegimenfiscal CRegimenfiscal = query.list().size() > 0 ? (CRegimenfiscal)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return CRegimenfiscal;
    }
}