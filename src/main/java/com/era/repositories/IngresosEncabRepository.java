/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.IngresosEncab;
import com.era.models.User;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class IngresosEncabRepository extends Repository {

    public IngresosEncabRepository() {
        super(IngresosEncab.class);
    }
    
    final public IngresosEncab getByNoserNorefer(final String noser, final String norefer) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM IngresosEncab WHERE noser = :noser AND norefer = :norefer";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("noser", noser);
        query.setParameter("norefer", norefer);
        List<IngresosEncab> list = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return list.size()>0?list.get(0):null;
    }
    
    @Override
    final public List<IngresosEncab> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<IngresosEncab> items = (List<IngresosEncab>) this.getAllLike(likes, search);
        
        return items;
    }
    
}
