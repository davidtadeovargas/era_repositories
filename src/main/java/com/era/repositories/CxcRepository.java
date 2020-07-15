/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Cxc;
import com.era.repositories.utils.HibernateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 *
 * @author PC
 */
public class CxcRepository extends Repository {

    public CxcRepository() {
        super(Cxc.class);
    }
    
    final public Cxc getByNorefer(final String norefer) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Cxc WHERE norefer = :norefer";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("norefer", norefer);
        List<Cxc> list = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return list.size()>0?list.get(0):null;
    }
    
    final public BigDecimal getTotalPositiveAmmountFromCustomer(final String customerCode) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Cxc WHERE empre = :customerCode";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("customerCode", customerCode);
        List<Cxc> list = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Iterate to get the sum
        BigDecimal totalPositive = BigDecimal.ZERO;        
        for(Cxc Cxc_:list){
            totalPositive = totalPositive.add(Cxc_.getAbon());            
        }
        
        //Return the result model
        return totalPositive;
    }
        
    final public BigDecimal getTotalNegativeAmmountFromCustomer(final String customerCode) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Cxc WHERE empre = :customerCode";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("customerCode", customerCode);
        List<Cxc> list = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Iterate to get the sum        
        BigDecimal totalNegative = BigDecimal.ZERO;
        for(Cxc Cxc_:list){            
            totalNegative = totalNegative.add(Cxc_.getCarg());
        }
        
        //Return the result model
        return totalNegative;
    }
    
    final public BigDecimal getSaldoFavorFromCustomer(final String customerCode) throws Exception{
        
        final BigDecimal positive = this.getTotalPositiveAmmountFromCustomer(customerCode);
        final BigDecimal negative = this.getTotalNegativeAmmountFromCustomer(customerCode);
        
        return positive.subtract(negative);
    }
    
    final public BigDecimal getSaldoContraFromCustomer(final String customerCode) throws Exception{
        
        final BigDecimal positive = this.getTotalPositiveAmmountFromCustomer(customerCode);
        final BigDecimal negative = this.getTotalNegativeAmmountFromCustomer(customerCode);
        
        return negative.subtract(positive);
    }
    
    final public Cxc getCXC(final String norefer,
                            final String noser,
                            final String id_venta,
                            final String empre) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Cxc WHERE norefer = :norefer AND noser = :noser AND id_venta = :id_venta AND empre = :empre";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("norefer", norefer);
        query.setParameter("noser", noser);
        query.setParameter("id_venta", id_venta);
        query.setParameter("empre", empre);
        List<Cxc> list = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return list.size()>0?list.get(0):null;
    }
    
    final public void deleteByConfg(final String norefer) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        //Save
        final SQLQuery SQLQuery = HibernateUtil.getSingleton().getSession().createSQLQuery("DELETE FROM Cxc WHERE norefer = :norefer");
        SQLQuery.setParameter("norefer", norefer);
        SQLQuery.executeUpdate();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
    }
    
    final public void cancelaCXC(final int id) throws Exception{
        
        final Cxc Cxc = (Cxc) this.getByID(id);        
        Cxc.setEstado("CA");        
        this.update(Cxc);
    }
    
    @Override
    final public List<Cxc> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<Cxc> items = (List<Cxc>) this.getAllLike(likes, search);
        
        return items;
    }
}
