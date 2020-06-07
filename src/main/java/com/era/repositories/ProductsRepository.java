package com.era.repositories;

import com.era.logger.LoggerUtility;
import com.era.models.Product;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class ProductsRepository extends Repository {

   public ProductsRepository() {
        super(Product.class);
    }
   
   final public Product getProductByCode(final String codeProduct) throws Exception {
                        
        LoggerUtility.getSingleton().logInfo(ProductsRepository.class, "Hibernate: Getting product by code " + codeProduct);
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Product where codeProduct = :codeProduct";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("codeProduct", codeProduct);
        Product Product = query.list().size() > 0 ? (Product) query.list().get(0):null;
                
        LoggerUtility.getSingleton().logInfo(ProductsRepository.class, "Hibernate: Returning Product: " + Product);
        
        //Return the response model
        return Product;
    }
    
    
    final public Product addOrUpdateProduct(final Product Product) throws Exception {                                
        
        //Get the product
        final Product Product_ = (Product)this.getByID(Product.getId());
                
        if(Product_==null){
            LoggerUtility.getSingleton().logInfo(ProductsRepository.class, "Hibernate: Adding Product");
        }
        else{
            LoggerUtility.getSingleton().logInfo(ProductsRepository.class, "Hibernate: Updating Product");
        }
        
        //Save or update the product        
        save(Product);
        
        LoggerUtility.getSingleton().logInfo(ProductsRepository.class, "Hibernate: Product created or updated");
        
        //Return the response model
        return Product;
    }
            
    final public Product deleteProductByCode(final String codeProduct) throws Exception {

        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        //Get the license
        final Product Product = this.getProductByCode(codeProduct);
        
        //Delete the license
        if(Product!=null){
            HibernateUtil.getSingleton().getSession().delete(Product);
        }            
        
        //Close database
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        return Product;
    }
    
    final public void deleteProductWithTaxes(final String prod) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
                
        SQLQuery SQLQuery = HibernateUtil.getSingleton().getSession().createSQLQuery("DELETE FROM Product WHERE prod = :prod");
        SQLQuery.setParameter("prod", prod);
        SQLQuery.executeUpdate();
        
        SQLQuery = HibernateUtil.getSingleton().getSession().createSQLQuery("DELETE FROM ImpuesXProduct WHERE produ = :prod");
        SQLQuery.setParameter("prod", prod);
        SQLQuery.executeUpdate();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
    }
    
    final public List<Product> getAllOrderdByProdAsc() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Product ORDER BY prod ASC";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        List<Product> prods = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return prods;
    }
    
    final public List<Product> getAllProdsWithSerie() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Product WHERE serialNumber =! '' ORDER BY prod DESC";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        List<Product> prods = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return prods;
    }
    
    final public List<Product> getAllProdsNotSerie() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Product WHERE serialNumber = '' ORDER BY prod DESC";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        List<Product> prods = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return prods;
    }
    
    final public List<Product> getAllCompuests() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Product WHERE compound = 0 ORDER BY prod DESC";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        List<Product> prods = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return prods;
    }
    
    final public List<Product> getAllOrderdByProdDes() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Product ORDER BY prod DESC";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        List<Product> prods = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return prods;
    }
    
    final public List<Product> getAllByLine(final String lin) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Product WHERE lin = :lin";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("lin", lin);
        List<Product> prods = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
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
    
    @Override
    final public List<Product> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<Product> items = (List<Product>) this.getAllLike(likes, search);
        
        return items;
    }
}