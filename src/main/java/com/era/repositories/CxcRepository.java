/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Company;
import com.era.models.Cxc;
import com.era.repositories.utils.HibernateUtil;
import com.era.repositories.utils.SatusDocuments;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    
    final public List<Cxc> getAllPaymentFromCustomerByStatus(final String customerCode, final List<String> statuses, final Date from, final Date until, final int vencidoDays) throws Exception{
        
        //Open database
        openDatabase();
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(until); // Now use today date.
        c.add(Calendar.DATE, 0);
        Date fromDate = null, toDate = null;
        String fromDateStr;
        String toDateStr;
        
        String hql;        
        if(vencidoDays==-1){
                        
            fromDateStr = formatter.format(from);
            toDateStr = formatter.format(c.getTime());
            fromDate = formatter.parse(fromDateStr);
            toDate = formatter.parse(toDateStr);

            hql = "FROM Cxc WHERE empre = :customerCode AND falt BETWEEN :from AND :until";
        }
        else{                        
            
            //Today date
            Calendar todayCalendar = Calendar.getInstance();
            todayCalendar.setTime(new Date());
            
            //Today plus days
            Calendar untilCalendar = Calendar.getInstance();
            untilCalendar.setTime(new Date());
            untilCalendar.add(Calendar.DATE, vencidoDays);
            
            fromDateStr = formatter.format(todayCalendar.getTime());
            toDateStr = formatter.format(untilCalendar.getTime());
            fromDate = formatter.parse(fromDateStr);
            toDate = formatter.parse(toDateStr);
        
            hql = "FROM Cxc WHERE empre = :customerCode AND falt BETWEEN :from AND :until AND estado = :estado";
        }
        
        if(vencidoDays==-1){
            
            if(statuses.size()>0){
                hql = hql + " AND estado IN(";

                for(String estatus:statuses){
                    hql = hql + ":" + estatus + ",";
                }

                hql = hql.substring(0, hql.length() - 1);
                hql = hql + ")";
            }
        }
                
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);        
        query.setParameter("customerCode", customerCode);
        query.setParameter("from", fromDate);
        query.setParameter("until", toDate);
        
        if(vencidoDays==-1){
            
            for(String estatus:statuses){
                query.setParameter(estatus, estatus);
            }
        }
        else{
            query.setParameter("estado", SatusDocuments.getSingleton().getPendingEstate());
        }
                    
        List<Cxc> list = query.list();
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return list;
    }
    
    final public Cxc getByNorefer(final String norefer) throws Exception{
        
        //Open database
        openDatabase();        
        
        String hql = "FROM Cxc WHERE norefer = :norefer";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("norefer", norefer);
        List<Cxc> list = query.list();
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return list.size()>0?list.get(0):null;
    }
    
    final public BigDecimal getTotalPositiveAmmountFromCustomer(final String customerCode) throws Exception{
        
        //Open database
        openDatabase();        
        
        String hql = "FROM Cxc WHERE empre = :customerCode";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("customerCode", customerCode);
        List<Cxc> list = query.list();
        
        //Close database        
        closeDatabase();
        
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
        openDatabase();        
        
        String hql = "FROM Cxc WHERE empre = :customerCode";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("customerCode", customerCode);
        List<Cxc> list = query.list();
        
        //Close database        
        closeDatabase();
        
        //Iterate to get the sum        
        BigDecimal totalNegative = BigDecimal.ZERO;
        for(Cxc Cxc_:list){            
            totalNegative = totalNegative.add(Cxc_.getCarg());
        }
        
        //Return the result model
        return totalNegative;
    }
    
    final public BigDecimal getSaldoFavorFromCustomer(final String customerCode) throws Exception{
        
        final BigDecimal negative = this.getTotalNegativeAmmountFromCustomer(customerCode);
        final BigDecimal positive = this.getTotalPositiveAmmountFromCustomer(customerCode);        
        
        final Company Company = RepositoryFactory.getInstance().getCompanysRepository().getCustomerByCode(customerCode);
        final BigDecimal limitCred = Company.getLimtcred();
        
        final BigDecimal cxcPending = negative.subtract(positive);
        
        final BigDecimal totalFree = limitCred.subtract(cxcPending);
        
        return totalFree;
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
        openDatabase();        
        
        String hql = "FROM Cxc WHERE norefer = :norefer AND noser = :noser AND id_venta = :id_venta AND empre = :empre";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("norefer", norefer);
        query.setParameter("noser", noser);
        query.setParameter("id_venta", id_venta);
        query.setParameter("empre", empre);
        List<Cxc> list = query.list();
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return list.size()>0?list.get(0):null;
    }
    
    final public void deleteByConfg(final String norefer) throws Exception{
        
        //Open database
        openDatabase();        
        
        //Save
        final SQLQuery SQLQuery = HibernateUtil.getSingleton().getSession().createSQLQuery("DELETE FROM Cxc WHERE norefer = :norefer");
        SQLQuery.setParameter("norefer", norefer);
        SQLQuery.executeUpdate();
        
        //Close database        
        closeDatabase();
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
