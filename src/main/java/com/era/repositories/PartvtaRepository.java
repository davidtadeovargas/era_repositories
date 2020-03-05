/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Partvta;
import com.era.repositories.utils.HibernateUtil;
import java.util.Iterator;
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
    
        
    final public int getPartidasXImpuesto(final String codimpue) throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();        
        
        String hql = "select count(*) from Partvta where codimpue = :codimpue";
        Query query = session.createQuery(hql);
        query.setParameter("codimpue", codimpue);
        Iterator count = query.iterate();
        
        //Close database
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return (int) count.next();
    }
}
