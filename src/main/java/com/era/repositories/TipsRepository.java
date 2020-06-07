/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Tips;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class TipsRepository extends Repository {

    public TipsRepository() {
        super(Tips.class);
    }

    final public Tips getBytType(final String type) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Tips where cod = :type";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("cod", type);
        Tips Tips = query.list().size() > 0 ? (Tips)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
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
