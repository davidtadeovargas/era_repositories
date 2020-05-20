/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Confgral;
import com.era.repositories.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 *
 * @author PC
 */
public class ConfgralRepository extends Repository {

    public ConfgralRepository() {
        super(Confgral.class);
    }
    
    final public void disableAllConfigs() throws Exception{
        this.updateSQL("UPDATE Confgral SET val = 0");
    }
    
    final public Confgral getSistemClasifByConf(final String conf) throws Exception {
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String hql = "FROM Confgral where clasif = 'sist' AND conf = :conf";
        Query query = session.createQuery(hql);
        query.setParameter("conf", conf);
        Confgral Confgral = query.list().size() > 0 ? (Confgral)query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Confgral;
    }
    
    final public Confgral getSalesClasifByConf(final String conf) throws Exception {
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String hql = "FROM Confgral where clasif = 'vtas' AND conf = :conf";
        Query query = session.createQuery(hql);
        query.setParameter("conf", conf);
        Confgral Confgral = query.list().size() > 0 ? (Confgral)query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Confgral;
    }
    
    final public String getPtovtaAlmacen() throws Exception {
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String hql = "FROM Confgral where clasif = 'vtas' AND conf = :conf";
        Query query = session.createQuery(hql);
        query.setParameter("conf", "almapto");
        Confgral Confgral = query.list().size() > 0 ? (Confgral)query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        final String almacen = Confgral==null?null:Confgral.getExtr();
        
        return almacen;
    }
    
    final public Confgral getByClasif(final String clasif) throws Exception {
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String hql = "FROM Confgral where clasif = :clasif";
        Query query = session.createQuery(hql);
        query.setParameter("clasif", clasif);
        Confgral Confgral = query.list().size() > 0 ? (Confgral)query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Confgral;
    }
    
    
    final public Confgral getByConfigPostdecimal() throws Exception {
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String hql = "FROM Confgral where clasif = :clasif AND conf = :conf";
        Query query = session.createQuery(hql);
        query.setParameter("clasif", "sist");
        query.setParameter("conf", "posdecimal");
        Confgral Confgral = query.list().size() > 0 ? (Confgral)query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Confgral;
    }
    
    final public boolean initWithSalesPointWindow() throws Exception {
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String hql = "FROM Confgral where clasif = :clasif AND conf = :conf";
        Query query = session.createQuery(hql);
        query.setParameter("clasif", "vtas");
        query.setParameter("conf", "initpvta");
        Confgral Confgral = query.list().size() > 0 ? (Confgral)query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Confgral!=null?Confgral.getVal()==1:false;
    }
    
    final public List<Confgral> getAllActivesByClasif(final String clasif) throws Exception {
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String hql = "FROM Confgral where clasif = :clasif AND val = 1";
        Query query = session.createQuery(hql);
        query.setParameter("clasif", clasif);
        List<Confgral> list = query.list();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return list;
    }
    
    final public List<Confgral> getAllActivesByConf(final String clasif) throws Exception {
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String hql = "FROM Confgral where clasif = :clasif";
        Query query = session.createQuery(hql);
        query.setParameter("clasif", clasif);
        List<Confgral> list = query.list();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return list;
    }
    
    final public List<Confgral> getAllActivesConfs() throws Exception {
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String hql = "FROM Confgral where val = :val";
        Query query = session.createQuery(hql);
        query.setParameter("val", 1);
        List<Confgral> list = query.list();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return list;
    }
    
    final public void activeConfig(final String conf, final String clasif) throws Exception{
        this.updateSQL("UPDATE Confgral SET val = 1 WHERE conf = \"" + conf + "\" AND clasif = \"" + clasif + "\"");
    }
    
    final public void inverseConfig(final String conf, final String clasif) throws Exception{
        this.updateSQL("UPDATE Confgral SET val = if(val=1,0,1) WHERE conf = \"" + conf + "\" AND clasif = \"" + clasif + "\"");
    }
    
    final public void deleteByConfg(final String conf) throws Exception{
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        //Save
        final SQLQuery SQLQuery = session.createSQLQuery("DELETE FROM Confgral WHERE conf = :conf");
        SQLQuery.setParameter("conf", conf);
        SQLQuery.executeUpdate();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
    }
}
