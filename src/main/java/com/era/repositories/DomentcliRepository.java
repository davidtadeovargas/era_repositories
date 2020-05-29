/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Domentcli;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class DomentcliRepository extends Repository {

    public DomentcliRepository() {
        super(Domentcli.class);
    }
    
    
    final public Domentcli getByCustomer(final String codemp) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        HibernateUtil.getSingleton().getSession().beginTransaction();
        
        String hql = "FROM Domentcli where codemp = :codemp";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("codemp", codemp);
        Domentcli Domentcli = query.list().size() > 0 ? (Domentcli)query.list().get(0):null;
        
        //Close database
        HibernateUtil.getSingleton().getSession().getTransaction().commit();
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return Domentcli;
    }
    
    @Override
    final public List<Domentcli> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<Domentcli> items = (List<Domentcli>) this.getAllLike(likes, search);
        
        return items;
    }
}
