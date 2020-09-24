/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Ingres;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class IngresRepository extends Repository {

    public IngresRepository() {
        super(Ingres.class);
    }
    
    final public List<Ingres> geAllByNoserAndNoRefer(final String norefer,final String noser) throws Exception{
        
        //Open database
        openDatabase();
        
        String hql = "FROM Ingres WHERE norefer = :norefer AND noser = :noser";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("norefer", norefer);
        query.setParameter("noser", noser);
        List<Ingres> list = query.list();
        
        //Close database      
        closeDatabase();
        
        //Return the result model
        return list;
    }
    
    final public List<Ingres> geAllByIngresosEncabId(final int ingresosEncabId) throws Exception{
        
        //Open database
        openDatabase();        
        
        String hql = "FROM Ingres WHERE idIngresCab = :ingresosEncabId";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("ingresosEncabId", ingresosEncabId);
        List<Ingres> list = query.list();
        
        //Close database      
        closeDatabase();
        
        //Return the result model
        return list;
    }
    
    @Override
    final public List<Ingres> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<Ingres> items = (List<Ingres>) this.getAllLike(likes, search);
        
        return items;
    }
}
