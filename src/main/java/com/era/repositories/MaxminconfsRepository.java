package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Maxminconf;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;

public class MaxminconfsRepository extends Repository {

    public MaxminconfsRepository() {
        super(Maxminconf.class);
    }

    final public Maxminconf getByUser(final String userCode) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Maxminconf where estacglo = :userCode";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("userCode", userCode);
        Maxminconf Maxminconf = query.list().size() > 0 ? (Maxminconf)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Maxminconf;
    }
    
    @Override
    final public List<Maxminconf> getByLikeEncabezados(final String search) throws Exception{

        final List<String> likes = new ArrayList<>();
        likes.add("falt");
        likes.add("fmod");

        final List<Maxminconf> records = (List<Maxminconf>) this.getAllLike(likes, search);

        return records;
    }
}