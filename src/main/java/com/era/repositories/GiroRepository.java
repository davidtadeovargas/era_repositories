/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Giro;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class GiroRepository extends Repository {

    public GiroRepository() {
        super(Giro.class);
    }
 
    final public Giro getByGiro(final String gir) throws Exception {
        
        //Open database
        openDatabase();
        
        String hql = "FROM Giro where gir = :gir";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("gir", gir);
        Giro Giro = query.list().size() > 0 ? (Giro)query.list().get(0):null;
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return Giro;
    }
    
    @Override
    final public List<Giro> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<Giro> items = (List<Giro>) this.getAllLike(likes, search);
        
        return items;
    }
}
