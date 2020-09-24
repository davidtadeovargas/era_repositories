/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.ERPermisos;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class ERPermisosRepository extends Repository {

    public ERPermisosRepository() {
        super(ERPermisos.class);
    }
    
    
    final public ERPermisos getByUsuario(final int FKIdUsuario) throws Exception {
        
        //Open database
        openDatabase();
        
        String hql = "FROM ERPermisos where FKIdUsuario = :FKIdUsuario";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("FKIdUsuario", FKIdUsuario);        
        ERPermisos ERPermisos = query.list().size() > 0 ? (ERPermisos)query.list().get(0):null;
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return ERPermisos;
    }
    
    @Override
    final public List<ERPermisos> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<ERPermisos> items = (List<ERPermisos>) this.getAllLike(likes, search);
        
        return items;
    }
}
