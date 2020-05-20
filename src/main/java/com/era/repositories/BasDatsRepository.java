/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.repositories.utils.HibernateUtil;
import com.era.logger.LoggerUtility;
import com.era.models.BasDats;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class BasDatsRepository extends Repository {
    
    protected BasDatsRepository(){
        super(BasDats.class);
    }
    
    final public BasDats getByCompanyCode(final String companyCode) throws Exception{
        
        LoggerUtility.getSingleton().logInfo(BasDatsRepository.class, "Hibernate: Getting basdats by code: " + companyCode);
        
        //Open database
        this.openSession();
        
        String hql = "FROM BasDats where codemp = :codemp";
        Query query = session.createQuery(hql);
        query.setParameter("codemp", companyCode);
        BasDats BasDats = query.list().size() > 0 ? (BasDats)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        LoggerUtility.getSingleton().logInfo(BasDatsRepository.class, "Hibernate: BasDats returned");
        
        //Return the result model
        return BasDats;
    }
    
    final public BasDats getByDBName(final String bd) throws Exception{
                        
        LoggerUtility.getSingleton().logInfo(BasDatsRepository.class, "Hibernate: Getting basdats by bd: " + bd);
        
        //Open database
        this.openSession();
        
        String hql = "FROM BasDats where bd = :bd";
        Query query = session.createQuery(hql);
        query.setParameter("bd", bd);
        BasDats BasDats = query.list().size() > 0 ? (BasDats)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        LoggerUtility.getSingleton().logInfo(BasDatsRepository.class, "Hibernate: BasDats returned");
        
        //Return the result model
        return BasDats;
    }
    
    final public BasDats deleteBasDats(final String companyCode) throws Exception {
        
        LoggerUtility.getSingleton().logInfo(CompanyRepository.class, "Hibernate: Deleting basdats by code: " + companyCode);
        
        //Get the company
        final BasDats BasDats = getByCompanyCode(companyCode);
        if(BasDats!=null){
            delete(BasDats);
        }
        
        LoggerUtility.getSingleton().logInfo(CompanyRepository.class, "Hibernate: BasDats deleted");
        
        return BasDats;
    }
}