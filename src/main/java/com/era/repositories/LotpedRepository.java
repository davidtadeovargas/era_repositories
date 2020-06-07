/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Lotped;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class LotpedRepository extends Repository {

    public LotpedRepository() {
        super(Lotped.class);
    }
 
    final public Lotped getByLotAndPed(final String lot, final String pedimen) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Lotped where lot = :lot AND configuration = :configuration AND pedimen = :pedimen";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("lot", lot);
        query.setParameter("pedimen", pedimen);
        Lotped Lotped = query.list().size() > 0 ? (Lotped)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Lotped;
    }
    
    @Override
    final public List<Lotped> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<Lotped> items = (List<Lotped>) this.getAllLike(likes, search);
        
        return items;
    }
}
