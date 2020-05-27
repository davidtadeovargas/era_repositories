package com.era.repositories;

import com.era.logger.LoggerUtility;
import com.era.models.BasDats;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;

public class BasDatssRepository extends Repository {

   public BasDatssRepository() {
        super(BasDats.class);
    }
   
   final public BasDats getByCompanyCode(final String companyCode) throws Exception{
        
        LoggerUtility.getSingleton().logInfo(BasDatssRepository.class, "Hibernate: Getting basdats by code: " + companyCode);
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM BasDats where codemp = :codemp";        
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("codemp", companyCode);
        BasDats BasDats = query.list().size() > 0 ? (BasDats)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        LoggerUtility.getSingleton().logInfo(BasDatssRepository.class, "Hibernate: BasDats returned");
        
        //Return the result model
        return BasDats;
    }
    
    final public BasDats getByDBName(final String bd) throws Exception{
                        
        LoggerUtility.getSingleton().logInfo(BasDatssRepository.class, "Hibernate: Getting basdats by bd: " + bd);
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM BasDats where bd = :bd";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("bd", bd);
        BasDats BasDats = query.list().size() > 0 ? (BasDats)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        LoggerUtility.getSingleton().logInfo(BasDatssRepository.class, "Hibernate: BasDats returned");
        
        //Return the result model
        return BasDats;
    }
    
    final public BasDats deleteBasDats(final String companyCode) throws Exception {
        
        LoggerUtility.getSingleton().logInfo(BasDatssRepository.class, "Hibernate: Deleting basdats by code: " + companyCode);
        
        //Get the company
        final BasDats BasDats = getByCompanyCode(companyCode);
        if(BasDats!=null){
            delete(BasDats);
        }
        
        LoggerUtility.getSingleton().logInfo(BasDatssRepository.class, "Hibernate: BasDats deleted");
        
        return BasDats;
    }
}