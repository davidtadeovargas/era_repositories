package com.era.repositories;

import com.era.models.Tips;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

public class TipssRepository extends Repository {

   public TipssRepository() {
        super(Tips.class);
    }
   
   final public Tips getBytType(final String type) throws Exception {
        
        //Open database
        openDatabase();
        
        String hql = "FROM Tips where code = :type";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("type", type);
        Tips Tips = query.list().size() > 0 ? (Tips)query.list().get(0):null;
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return Tips;
    }
    
    final public Tips getFacType() throws Exception {
        return getBytType("FAC");
    }
    
    final public Tips getNotCType() throws Exception {
        return getBytType("NOTC");
    }
    
    final public Tips getTickType() throws Exception {
        return getBytType("TIK");
    }
    
    final public Tips getRemType() throws Exception {
        return getBytType("REM");
    }
    
    @Override
    final public List<Tips> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<Tips> items = (List<Tips>) this.getAllLike(likes, search);
        
        return items;
    }
}