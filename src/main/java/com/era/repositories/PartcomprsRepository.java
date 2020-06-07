/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Partcomprs;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class PartcomprsRepository extends Repository {

    public PartcomprsRepository() {
        super(Partcomprs.class);
    }
    
    
    final public List<Partcomprs> getAllByComp(final String codcom) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Partcomprs where codcom = :codcom";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("codcom", codcom);        
        List<Partcomprs> parts = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return parts;
    }
    
    @Override
    final public List<Partcomprs> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<Partcomprs> items = (List<Partcomprs>) this.getAllLike(likes, search);
        
        return items;
    }
}
