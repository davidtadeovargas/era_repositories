package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.CClaveprodserv;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class CClaveprodservsRepository extends Repository {

    public CClaveprodservsRepository() {
        super(CClaveprodserv.class);
    }

    
    @Override
    public List<?> getAllByPageWithSearchFilter(final String search, final int pageNumber, int pageSize) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);       
        
        final Session Session = HibernateUtil.getSingleton().getSession();
        
        String hql = "FROM CClaveprodserv WHERE c_ClaveProdServ LIKE:c_ClaveProdServ OR description LIKE:description";
        Query query = Session.createQuery(hql);
        query.setParameter("c_ClaveProdServ", "%" + search + "%");
        query.setParameter("description", "%" + search + "%");        
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);        
        List<?> records = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return records;
    }
    
    @Override
    public Object getByCode(final String code) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM CClaveprodserv where c_ClaveProdServ = :code";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("code", code);
        CClaveprodserv CClaveprodserv = query.list().size() > 0 ? (CClaveprodserv)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return CClaveprodserv;
    }
    
    @Override
    final public List<CClaveprodserv> getByLikeEncabezados(final String search) throws Exception{

        final List<String> likes = new ArrayList<>();
        likes.add("falt");
        likes.add("fmod");

        final List<CClaveprodserv> records = (List<CClaveprodserv>) this.getAllLike(likes, search);

        return records;
    }

}