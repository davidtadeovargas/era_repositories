/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Partvta;
import com.era.models.User;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class PartvtaRepository extends Repository {

    public PartvtaRepository() {
        super(Partvta.class);
    }
    
    final public void paridaDevolucion(final int id, final int cantidad) throws Exception{
        this.updateSQL("UPDATE partvta SET devs = devs - " + cantidad + " WHERE id_id  = " + id);
    }
    
        
    final public List<Partvta> getPartsVta(final int saleId) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Partvta where vta = :vta";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("vta", saleId);
        List<Partvta> parts = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return parts;
    }
    
    final public int getPartidasXImpuesto(final String codimpue) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "select count(*) from Partvta where codimpue = :codimpue";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("codimpue", codimpue);
        Iterator count = query.iterate();
        
        //Close database
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return (int) count.next();
    }
    
    @Override
    final public List<Partvta> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<Partvta> items = (List<Partvta>) this.getAllLike(likes, search);
        
        return items;
    }
}
