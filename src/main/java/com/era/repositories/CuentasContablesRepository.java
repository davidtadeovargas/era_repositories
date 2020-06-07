/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.CuentasContables;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class CuentasContablesRepository extends Repository {

    public CuentasContablesRepository() {
        super(CuentasContables.class);
    }
    
    final public CuentasContables getByCuenta(final String cuenta) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM CuentasContables where cuenta = :cuenta";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("cuenta", cuenta);
        CuentasContables CuentasContables = query.list().size() > 0 ? (CuentasContables)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return CuentasContables;
    }
    
    @Override
    final public List<CuentasContables> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<CuentasContables> items = (List<CuentasContables>) this.getAllLike(likes, search);
        
        return items;
    }
}
