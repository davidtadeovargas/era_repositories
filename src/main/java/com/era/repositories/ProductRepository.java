/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.repositories.utils.HibernateUtil;
import com.era.logger.LoggerUtility;
import com.era.models.Product;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 *
 * @author PC
 */
public class ProductRepository extends Repository {

    protected ProductRepository(){
        super(Product.class);
    }
    
    final public Product getProductByCode(final String codeProduct) throws Exception {
                        
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: Getting product by code " + codeProduct);
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();        
        
        String hql = "FROM Product where codeProduct = :codeProduct";
        Query query = session.createQuery(hql);
        query.setParameter("codeProduct", codeProduct);
        Product Product = query.list().size() > 0 ? (Product) query.list().get(0):null;
                
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: Returning Product: " + Product);
        
        //Return the response model
        return Product;
    }
    
    
    final public Product addOrUpdateProduct(final Product Product) throws Exception {                                
        
        //Get the product
        final Product Product_ = (Product)this.getByID(Product.getId());
                
        if(Product_==null){
            LoggerUtility.getSingleton().logInfo(ProductRepository.class, "Hibernate: Adding Product");
        }
        else{
            LoggerUtility.getSingleton().logInfo(ProductRepository.class, "Hibernate: Updating Product");
        }
        
        //Save or update the product
        save(Product);
        
        LoggerUtility.getSingleton().logInfo(ProductRepository.class, "Hibernate: Product created or updated");
        
        //Return the response model
        return Product;
    }
            
    final public Product deleteProductByCode(final String codeProduct) throws Exception {

        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();        
        
        //Get the license
        final Product Product = this.getProductByCode(codeProduct);
        
        //Delete the license
        if(Product!=null){
            session.delete(Product);
        }            
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        return Product;
    }
    
    final public void deleteProductWithTaxes(final String prod) throws Exception{
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        session.beginTransaction();
                
        SQLQuery SQLQuery = session.createSQLQuery("DELETE FROM Product WHERE prod = :prod");
        SQLQuery.setParameter("prod", prod);
        SQLQuery.executeUpdate();
        
        SQLQuery = session.createSQLQuery("DELETE FROM ImpuesXProduct WHERE produ = :prod");
        SQLQuery.setParameter("prod", prod);
        SQLQuery.executeUpdate();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
    }
    
    final public List<Product> getAllOrderdByProdAsc() throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        
        String hql = "FROM Product ORDER BY prod ASC";
        Query query = session.createQuery(hql);
        List<Product> prods = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return prods;
    }
    
    final public List<Product> getAllProdsWithSerie() throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        
        String hql = "FROM Product WHERE serialNumber =! '' ORDER BY prod DESC";
        Query query = session.createQuery(hql);
        List<Product> prods = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return prods;
    }
    
    final public List<Product> getAllProdsNotSerie() throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        
        String hql = "FROM Product WHERE serialNumber = '' ORDER BY prod DESC";
        Query query = session.createQuery(hql);
        List<Product> prods = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return prods;
    }
    
    final public List<Product> getAllCompuests() throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        
        String hql = "FROM Product WHERE compound = 0 ORDER BY prod DESC";
        Query query = session.createQuery(hql);
        List<Product> prods = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return prods;
    }
    
    final public List<Product> getAllOrderdByProdDes() throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        
        String hql = "FROM Product ORDER BY prod DESC";
        Query query = session.createQuery(hql);
        List<Product> prods = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return prods;
    }
    
    final public List<Product> getAllByLine(final String lin) throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        
        String hql = "FROM Product WHERE lin = :lin";
        Query query = session.createQuery(hql);
        query.setParameter("lin", lin);
        List<Product> prods = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return prods;
    }
    
    
    final public void updateAllProductsSaleUnderCost() throws Exception{       
        this.updateSQL("UPDATE Product SET bajcost = 1");
    }
    
    
    final public void updateAllProductsNotSaleUnderCost() throws Exception{
        this.updateSQL("UPDATE Product SET bajcost = 0");
    }
    
    final public void updateAllProductsSaleOrNotUnderCost(final int bajcost) throws Exception{
        this.updateSQL("UPDATE Product SET bajcost = " + bajcost);
    }
    
    
    final public void updateAllProductsSolmaxmin() throws Exception{
        this.updateSQL("UPDATE Product SET askMaxMin = 1");
    }
    
    final public void updateAllProductsNotSolmaxmin() throws Exception{
        this.updateSQL("UPDATE Product SET askMaxMin = 0");
    }
    
    final public void updateAllProductsSolOrNotSolMaxmin(final int askMaxMin) throws Exception{
        this.updateSQL("UPDATE Product SET askMaxMin = " + askMaxMin);
    }
}
