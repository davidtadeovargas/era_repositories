/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.ImpuesXProduct;
import com.era.models.Tax;
import com.era.repositories.exceptions.RecordExistsException;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class ImpuesXProductRepository extends Repository {

    public ImpuesXProductRepository() {
        super(ImpuesXProduct.class);
    }
 
    final public List<ImpuesXProduct> getAllByProd(final String produ) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        HibernateUtil.getSingleton().begginTransaction();        
        
        String hql = "FROM ImpuesXProduct WHERE code = :code";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("code", produ);
        List<ImpuesXProduct> list = query.list();
        
        //Close database
        HibernateUtil.getSingleton().commitTransacton();
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return list;
    }
    
    final void deleteAllTaxesFromProduct(final String productCode) throws Exception {        
        this.deleteSQL("DELETE FROM impues_x_product WHERE code = '" + productCode + "'");
    }            
    
    final public void save(final String productCode, final List<ImpuesXProduct> taxes) throws Exception {
        
        //Loop over all the taxes
        for(ImpuesXProduct ImpuesXProduct:taxes){
          
            //Checj if the record exists
            final boolean exists = taxExistsInProduct(productCode, ImpuesXProduct.getCode());
            
            //If not exists            
            if(!exists){
                
                //Save it
                this.save(ImpuesXProduct);
            }
        }
    }
    
    final public ImpuesXProduct saveTaxForProduct(final String productCode, final String taxCode) throws Exception {
        
        //The record can not exists
        ImpuesXProduct ImpuesXProduct = this.getByProductAndTax(productCode, taxCode);
        if(ImpuesXProduct==null){
         
            //Create the model
            ImpuesXProduct = new ImpuesXProduct();
            ImpuesXProduct.setCode(productCode);
            ImpuesXProduct.setImpue(taxCode);

            //Save into database
            this.save(ImpuesXProduct);

            //Return the saved model
            return ImpuesXProduct;
        }
        else{
            return null;
        }
    }
    
    @Override
    final public List<ImpuesXProduct> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<ImpuesXProduct> items = (List<ImpuesXProduct>) this.getAllLike(likes, search);
        
        return items;
    }
    
    final public List<Tax> getProductTaxes(final String productCode) throws Exception{
        
       //Get all the taxes of the product
       final List<ImpuesXProduct> records = (List<ImpuesXProduct>) this.getAllByCode(productCode);
       
       //Crate the new result list
       final List<Tax> taxes = new ArrayList<>();
       for(ImpuesXProduct ImpuesXProduct: records){
           final Tax Tax = (Tax)RepositoryFactory.getInstance().getTaxesRepository().getByCode(ImpuesXProduct.getImpue());
           taxes.add(Tax);
       }
       
       return taxes;
   }
    
    final public boolean taxExistsInProduct(final String productCode, final String taxCode) throws Exception{               
        return getByProductAndTax(productCode, taxCode)!=null;
   }
    
    final public ImpuesXProduct getByProductAndTax(final String productCode, final String taxCode) throws Exception{
        
       //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM ImpuesXProduct where code = :productCode AND impue = :taxCode";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("productCode", productCode);
        query.setParameter("taxCode", taxCode);
        ImpuesXProduct ImpuesXProduct = query.list().size() > 0 ? (ImpuesXProduct)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return ImpuesXProduct;
   }
}