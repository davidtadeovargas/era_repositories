/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Cxp;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 *
 * @author PC
 */
public class CxpRepository extends Repository {

    public CxpRepository() {
        super(Cxp.class);
    }
    
    final public Cxp getByNorefer(final String norefer) throws Exception{
        
        //Open database
        openDatabase();
        
        String hql = "FROM Cxp WHERE norefer = :norefer";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("norefer", norefer);
        List<Cxp> list = query.list();
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return list.size()>0?list.get(0):null;
    }
    
    final public void deleteByConfg(final String norefer) throws Exception{
        
        //Open database
        openDatabase();        
        
        //Save
        final SQLQuery SQLQuery = HibernateUtil.getSingleton().getSession().createSQLQuery("DELETE FROM Cxp WHERE norefer = :norefer");
        SQLQuery.setParameter("norefer", norefer);
        SQLQuery.executeUpdate();
        
        //Close database        
        closeDatabase();
    }
    
    final public double getPendientePago(final String prov) throws Exception{
        
        //Open database
        openDatabase();        
        
        //Save
        final SQLQuery SQLQuery = HibernateUtil.getSingleton().getSession().createSQLQuery("SELECT IFNULL((SUM(carg) - SUM(abon)),0) AS pendpag WHERE prov = :prov");
        SQLQuery.setParameter("norefer", prov);
        List<Object[]> rows = SQLQuery.list();
        double pendiente = 0;
        if(rows.size()>0){
            pendiente = Double.valueOf(Arrays.toString(rows.get(0)));
        }
        
        //Close database        
        closeDatabase();
        
        return pendiente;
    }
    
    @Override
    final public List<Cxp> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<Cxp> items = (List<Cxp>) this.getAllLike(likes, search);
        
        return items;
    }
}
