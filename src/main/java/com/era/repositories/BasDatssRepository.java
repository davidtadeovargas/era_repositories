package com.era.repositories;

import com.era.logger.LoggerUtility;
import com.era.models.BasDats;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.classic.Session;

public class BasDatssRepository extends Repository {

    public BasDatssRepository() {
        super(BasDats.class);
    }
   
    @Override
    public List<?> getAllBySearchFilter(final String search) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);       
        
        final Session Session = HibernateUtil.getSingleton().getSession();
        
        String hql = "FROM " + ClassEntity.getName() + " WHERE nom LIKE:name OR codemp LIKE:companyCode OR RFC LIKE:RFC";
        Query query = Session.createQuery(hql);
        query.setParameter("name", "%" + search + "%");
        query.setParameter("companyCode", "%" + search + "%");
        query.setParameter("RFC", "%" + search + "%");
        List<?> records = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return records;
    }
   
    @Override
    public List<?> getAllByPageWithSearchFilter(final String search, final int pageNumber, int pageSize) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);       
        
        final Session Session = HibernateUtil.getSingleton().getSession();
        
        String hql = "FROM " + ClassEntity.getName() + " WHERE nom LIKE:name OR codemp LIKE:companyCode OR RFC LIKE:RFC";
        Query query = Session.createQuery(hql);
        query.setParameter("name", search);
        query.setParameter("companyCode", search);
        query.setParameter("RFC", search);
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);        
        List<?> records = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return records;
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
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        LoggerUtility.getSingleton().logInfo(BasDatssRepository.class, "Hibernate: BasDats returned");
        
        //Return the result model
        return BasDats;
    }
    
   final public BasDats getDBTest() throws Exception{
        
        LoggerUtility.getSingleton().logInfo(BasDatssRepository.class, "Hibernate: Getting the db test");
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM BasDats where test = true";        
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);        
        BasDats BasDats = query.list().size() > 0 ? (BasDats)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        LoggerUtility.getSingleton().logInfo(BasDatssRepository.class, "Hibernate: DB test returned");
        
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
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
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
    
    @Override
    final public List<BasDats> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<BasDats> items = (List<BasDats>) this.getAllLike(likes, search);
        
        return items;
    }
}