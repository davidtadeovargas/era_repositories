/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.repositories.utils.HibernateUtil;
import com.era.models.DeliverAddressCustomer;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class DeliverAddressCustomerRepository extends Repository {
    
    protected DeliverAddressCustomerRepository(){
        super(DeliverAddressCustomer.class);
    }
    
    final public List<DeliverAddressCustomer> getByCustomerCode(final String customerCode) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        List<DeliverAddressCustomer> deliveries;
        String hql = "FROM DeliverAddressCustomer where customerCode = :customerCode";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("customerCode", customerCode);
        deliveries = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return deliveries;
    }
    
    final public DeliverAddressCustomer getByCustomerCodeSingle(final String customerCode) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        List<DeliverAddressCustomer> deliveries;
        String hql = "FROM DeliverAddressCustomer where customerCode = :customerCode";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("customerCode", customerCode);
        deliveries = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return deliveries.size()>0?deliveries.get(0):null;
    }
    
    final public void deleteByCustomerCode(final String customerCode) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        List<DeliverAddressCustomer> deliveries = this.getByCustomerCode(customerCode);
        for(DeliverAddressCustomer DeliverAddressCustomer:deliveries){
            HibernateUtil.getSingleton().getSession().delete(DeliverAddressCustomer);
        }
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
    }
}