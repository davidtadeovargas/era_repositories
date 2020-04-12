/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Sales;
import com.era.models.Tips;
import com.era.repositories.utils.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;

public class SalesRepository extends Repository {
    
    protected SalesRepository(){
        super(Sales.class);
    }
    
    final public int getTotalSalesFromCustomer(final String codemp) throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();        
        
        String hql = "select count(*) from Sales where codemp = :codemp";
        Query query = session.createQuery(hql);
        query.setParameter("codemp", codemp);
        Iterator count = query.iterate();
        
        //Close database
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return (int) count.next();
    }
    
    final public Sales getByNotCred(final String notcred) throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "FROM Sales where notcred = :notcred";
        Query query = session.createQuery(hql);
        query.setParameter("notcred", notcred);
        Sales Sales = query.list().size() > 0 ? (Sales)query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Sales;
    }
    
    final public Sales getByVentaRef(final String vtaRef) throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "FROM Sales where vtaRef = :vtaRef";
        Query query = session.createQuery(hql);
        query.setParameter("vtaRef", vtaRef);
        Sales Sales = query.list().size() > 0 ? (Sales)query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Sales;
    }
    
    final public List<Sales> getAllNotsCred() throws Exception {
        
        final Tips Tips = RepositoryFactory.getInstance().getTipsRepository().getFacType();
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        session.beginTransaction();
                
        String hql = "FROM Sales where tipdoc = :tipdoc";
        Query query = session.createQuery(hql);
        query.setParameter("tipdoc", Tips.getCod());
        List<Sales> Sales = query.list();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Sales;
    }
    
    final public Sales getByVenta(final int vta) throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "FROM Sales where vta = :vta";
        Query query = session.createQuery(hql);
        query.setParameter("vta", vta);
        Sales Sales = query.list().size() > 0 ? (Sales)query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Sales;
    }
    
    final public void actualizaVentaTimbrado(  final String transid,
                                                final String sell,
                                                final String certsat,
                                                final String lugexp,
                                                final String regfisc,
                                                final String sellsat,
                                                final String cadori,
                                                final String folfisc,
                                                final int vta) throws Exception {
        
        

        final Sales Sales = this.getByVenta(vta);
        Sales.setInvoiced(true);
        Sales.setTransactionID(transid);        
        Sales.setSell(sell);
        Sales.setSellsat(sellsat);
        Sales.setCadori(cadori);
        Sales.setFiscalFolio(folfisc);
        
        this.update(Sales);
    }
    
    
    final public void liberaRemisiones(final int vta) throws Exception{
        this.update("UPDATE Sales SET estatus = 'PE', vtaRef = 0 WHERE vtaRef = " + vta);
    }
    
    
    final public void confirmaVentaOrigen(final int venta_origen) throws Exception{
        this.update("UPDATE Sales SET estatus = 'CO', venta_origen = 0, factu = 0 WHERE venta_origen = " + venta_origen);
    }
}