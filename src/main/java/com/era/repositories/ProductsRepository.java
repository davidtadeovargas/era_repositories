package com.era.repositories;

import com.era.logger.LoggerUtility;
import com.era.models.ImpuesXProduct;
import com.era.models.Kits;
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
        
        String hql = "FROM Product where code = :codeProduct";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("codeProduct", codeProduct);
        Product Product = query.list().size() > 0 ? (Product) query.list().get(0):null;
                
        LoggerUtility.getSingleton().logInfo(ProductsRepository.class, "Hibernate: Returning Product: " + Product);
        
        //Return the response model
        return Product;
    }
    
   final public void updateProductAsKit(final String codeProduct) throws Exception {
                        
        Product Product = (Product)this.getByCode(codeProduct);
        
        //Set the product as kit
        if(Product!=null){
            
            Product.setCompound(true);

            this.update(Product);
        }
    }
   
    final public List<Product> getAllKits() throws Exception {
                        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Product where compound = true";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);        
        List<Product> Products = query.list();                        
        
        //Close database
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the response model
        return Products;
    }
    
    final public List<Product> getAllForSale() throws Exception {
                        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Product where isForSale = true";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);        
        List<Product> Products = query.list();                        
        
        //Close database
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the response model
        return Products;
    }
    
    final public Product addOrUpdateProduct(final Product Product) throws Exception {                                
        
        //Get the product
        final Product Product_ = (Product)this.getByID(Product.getId());
                
        if(Product_==null){
            LoggerUtility.getSingleton().logInfo(ProductsRepository.class, "Hibernate: Adding Product");
            
            //Save or update the product        
            save(Product);
        }
        else{
            LoggerUtility.getSingleton().logInfo(ProductsRepository.class, "Hibernate: Updating Product");
            
            //Update the product        
            update(Product);
        }
        
        LoggerUtility.getSingleton().logInfo(ProductsRepository.class, "Hibernate: Product created or updated");
        
        //Return the response model
        return Product;
    }
            
    final public Product addOrUpdateProduct(final Product Product, final List<ImpuesXProduct> taxesProduct, final List<Kits> kits) throws Exception {
        
        //Determine if previusly was a kit
        final Product ProductKit = (Product)this.getByCode(Product.getCode());
        boolean wasKit = false;
        if(ProductKit!=null && ProductKit.getCompound()){
            wasKit = true;
        }
        
        //Add or update the product
        final Product Product_ = addOrUpdateProduct(Product);
        
        //If it is not a kit
        if(!Product_.getCompound()){
            
            //If previusly was kit
            if(wasKit){
                
                //Delete all components
                RepositoryFactory.getInstance().getKitssRepository().deleteAllComponentsFromKit(Product_.getCode());
            }
        }
        else{ //It is a kit
            
            //Save the kits
            RepositoryFactory.getInstance().getKitssRepository().saveComponentsToKit(Product_.getCode(), kits);
        }
        
        //Save or update the taxes of the product
        RepositoryFactory.getInstance().getImpuesXProductRepository().save(Product.getCode(), taxesProduct);
                
        //Return the moel
        return Product_;
    }
    
    final public Product deleteProductByCode(final String codeProduct) throws Exception {

        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        //Get the product
        final Product Product = this.getProductByCode(codeProduct);
        
        //Delete the product
        if(Product!=null){
            HibernateUtil.getSingleton().getSession().delete(Product);
        }            
        
        //Delete all the taxes associated
        RepositoryFactory.getInstance().getImpuesXProductRepository().deleteAllTaxesFromProduct(codeProduct);
        
        //Is kit?
        if(Product.getCompound()){
            
            //Delete all the components associated
            RepositoryFactory.getInstance().getKitssRepository().deleteAllComponentsFromKit(codeProduct);
        }
        
        //Close database
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        return Product;
    }
    
    final public Product removeKit(final String codeProduct) throws Exception {

        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        //Get the product
        final Product Product = this.getProductByCode(codeProduct);
        
        //Remove the kit
        Product.setCompound(false);
        
        //Update
        HibernateUtil.getSingleton().getSession().update(Product);                    
        
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
    
    final public List<Product> getAllProductsSolMaxMin() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Product WHERE askMaxMin = true";
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
    
    final public List<Product> getAllByLine(final String codeLine) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Product WHERE codeLine = :codeLine";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("codeLine", codeLine);
        List<Product> prods = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return prods;
    }
    
    
    final public void updateAllProductsSaleUnderCost() throws Exception{       
        this.updateSQL("UPDATE prods SET bajcost = 1");
    }
    
    
    final public void updateAllProductsNotSaleUnderCost() throws Exception{
        this.updateSQL("UPDATE prods SET bajcost = 0");
    }
    
    final public void updateAllProductsSaleOrNotUnderCost(final int bajcost) throws Exception{
        this.updateSQL("UPDATE prods SET bajcost = " + bajcost);
    }
    
    
    final public void updateAllProductsSolmaxmin() throws Exception{
        this.updateSQL("UPDATE prods SET solmaxmin = 1");
    }
    
    final public void updateAllProductsNotSolmaxmin() throws Exception{
        this.updateSQL("UPDATE prods SET solmaxmin = 0");
    }
    
    @Override
    final public List<Product> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");        
        likes.add("description");
        likes.add("falt");
        likes.add("fmod");
        
        final List<Product> items = (List<Product>) this.getAllLike(likes, search);
        
        return items;
    }
}