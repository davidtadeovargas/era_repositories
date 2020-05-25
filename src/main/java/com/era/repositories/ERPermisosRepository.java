/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.ERPermisos;
import com.era.repositories.utils.HibernateUtil;
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
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM ERPermisos where FKIdUsuario = :FKIdUsuario";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("FKIdUsuario", FKIdUsuario);        
        ERPermisos ERPermisos = query.list().size() > 0 ? (ERPermisos)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return ERPermisos;
    }
}
