package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.CClaveprodserv;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;

public class CClaveprodservsRepository extends Repository {

    public CClaveprodservsRepository() {
        super(CClaveprodserv.class);
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