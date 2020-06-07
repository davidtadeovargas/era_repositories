/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Corrselec;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class CorrselecRepository extends Repository {

    public CorrselecRepository() {
        super(Corrselec.class);
    }
    
    final public List<Corrselec> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("srvsmtpsal");        
        
        final List<Corrselec> emails = (List<Corrselec>) this.getAllLike(likes, search);
        
        return emails;
    }
    
    final public Corrselec getByEstac(final String estac) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Sales where estac = :estac";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("estac", estac);
        Corrselec Corrselec = query.list().size() > 0 ? (Corrselec)query.list().get(0):null;
        
        //Close database       
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Corrselec;
    }
}
