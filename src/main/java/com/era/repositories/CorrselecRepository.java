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
    
    @Override
    final public List<Corrselec> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("srvsmtpsal");
        likes.add("portsmtp");
        likes.add("usr");
        likes.add("corralter");
        likes.add("estacglo");
        
        final List<Corrselec> emails = (List<Corrselec>) this.getAllLike(likes, search);
        
        return emails;
    }
    
    final public Corrselec getByEstacGlob(final String estacglo) throws Exception {
        
        //Open database
        openDatabase();
        
        String hql = "FROM Corrselec WHERE estacglo = :estacglo";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("estacglo", estacglo);
        Corrselec Corrselec = query.list().size() > 0 ? (Corrselec)query.list().get(0):null;
        
        //Close database
        closeDatabase();
        
        //Return the result model
        return Corrselec;
    }
}
