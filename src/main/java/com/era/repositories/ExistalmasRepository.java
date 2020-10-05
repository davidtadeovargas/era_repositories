package com.era.repositories;

import com.era.models.Conceps;
import java.util.List;
import java.util.ArrayList;
import com.era.models.Existalma;
import com.era.models.Moninven;
import com.era.models.Product;
import com.era.repositories.utils.HibernateUtil;
import java.math.BigDecimal;
import org.hibernate.Query;

public class ExistalmasRepository extends Repository {

    public ExistalmasRepository() {
         super(Existalma.class);
    }

    public void addExistenceToWarehouse(final String productCode, final String warehouseCode, final String unid, final float existence, final String nodoc,ConcepssRepository.TYPES typeMoninven) throws Exception {
        
        //Get the model
        Existalma Existalma = this.getByWarehouseAndProduct(warehouseCode, productCode);
        
        final float previousExitence;
        
        //If there is no previous record create it
        if(Existalma==null){
            
            previousExitence = 0;
            
            Existalma = new Existalma();
            Existalma.setAlma(warehouseCode);
            Existalma.setProd(productCode);
            Existalma.setExist((float)existence);
            this.save(Existalma);
        }
        else{
            
            previousExitence = Existalma.getExist();
        
            //Create new existence
            final float newExistence = Existalma.getExist() + existence;

            //Update the model
            Existalma.setExist(newExistence);
            this.update(Existalma);
        }
        
        //Get the type of concep
        final Conceps Concep = RepositoryFactory.getInstance().getConcepssRepository().getByType(typeMoninven);
        
        //Register the inventory movement
        final Moninven Moninven = new Moninven();
        Moninven.setProd(productCode);
        Moninven.setAlma(warehouseCode);
        Moninven.setExistenciainicial(new BigDecimal(Float.toString(previousExitence)));
        Moninven.setEntsal(true);
        Moninven.setEmp("");
        Moninven.setNodoc(nodoc);
        Moninven.setNoser("");
        Moninven.setDescrip(Concep.getDescrip());
        Moninven.setUnid(unid);
        Moninven.setConcep(Concep.getCode());        
        Moninven.setCant(existence);
        
        //Save the movement
        RepositoryFactory.getInstance().getMoninvensRepository().save(Moninven);
    }
   
    public void removeExistenceToWarehouse(final String productCode, final String warehouseCode, final String unid, final float existence, final String nodoc, ConcepssRepository.TYPES typeMoninven) throws Exception {
        
        //Get the model
        Existalma Existalma = this.getByWarehouseAndProduct(warehouseCode, productCode);
        
        final float previousExitence;
        
        //If there is no previous record create it
        if(Existalma==null){
            
            previousExitence = 0;
            
            Existalma = new Existalma();
            Existalma.setAlma(warehouseCode);
            Existalma.setProd(productCode);
            Existalma.setExist(0 - (float)existence);
            this.save(Existalma);
        }
        else{
            
            previousExitence = Existalma.getExist();
        
            //Create new existence
            final float newExistence = Existalma.getExist() - existence;

            //Update the model
            Existalma.setExist(newExistence);
            this.update(Existalma);
        }
        
        //Get the general existences of the product
        final float generalExistence = this.getGeneralExistenceFromProduct(productCode);
        
        //Update the general existence of the product
        RepositoryFactory.getInstance().getProductsRepository().updateGeneralExistence(productCode, generalExistence);
        
        //Get the type of concep
        final Conceps Concep = RepositoryFactory.getInstance().getConcepssRepository().getByType(typeMoninven);
        
        //Register the inventory movement
        final Moninven Moninven = new Moninven();
        Moninven.setProd(productCode);
        Moninven.setAlma(warehouseCode);
        Moninven.setExistenciainicial(new BigDecimal(Float.toString(previousExitence)));
        Moninven.setEntsal(false);
        Moninven.setEmp("");
        Moninven.setNodoc(nodoc);
        Moninven.setNoser("");
        Moninven.setUnid(unid);
        Moninven.setDescrip(Concep.getDescrip());
        Moninven.setConcep(Concep.getCode());        
        Moninven.setCant(existence);
        RepositoryFactory.getInstance().getMoninvensRepository().save(Moninven);
    }
    
    public void moveExistencesFromTo(final String productCode, final String warehouseFrom, final String warehouseTo, final String unid, final float existences) throws Exception {
        
        //Remove from the first warehouse
        this.removeExistenceToWarehouse(productCode, warehouseFrom, unid, existences, "", ConcepssRepository.TYPES.TRASPASO);
        
        //Add existences to the new warehouse
        this.addExistenceToWarehouse(productCode, warehouseTo, unid, existences,"", ConcepssRepository.TYPES.TRASPASO);
    }            
    
    final public void updateExistences(final String warehouseCode, final String productCode, final double existence) throws Exception {

        //If the record not exists create it
        Existalma Existalma = getByWarehouseAndProduct(warehouseCode, productCode);
        if(Existalma==null){
             Existalma = new Existalma();
             Existalma.setAlma(warehouseCode);
             Existalma.setProd(productCode);
             Existalma.setExist((float)existence);
             this.save(Existalma);
        }
        else{
            Existalma.setExist((float)existence);
            this.update(Existalma);
        }
    }

    final public Existalma getByWarehouseAndProduct(final String warehouseCode, final String productCode) throws Exception {

         //Open database
         openDatabase();

         String hql = "FROM Existalma where alma = :warehouseCode AND prod = :productCode";
         Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
         query.setParameter("warehouseCode", warehouseCode);
         query.setParameter("productCode", productCode);
         Existalma Existalma = query.list().size() > 0 ? (Existalma)query.list().get(0):null;

         //Close database        
         closeDatabase();

         //Return the result model
         return Existalma;
    }

    final public Existalma getByWarehouse(final String warehouseCode) throws Exception {

         //Open database
         openDatabase();

         String hql = "FROM Existalma where alma = :warehouseCode";
         Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
         query.setParameter("warehouseCode", warehouseCode);         
         Existalma Existalma = query.list().size() > 0 ? (Existalma)query.list().get(0):null;

         //Close database        
         closeDatabase();

         //Return the result model
         return Existalma;
    }
    
    final public List<Product> getAllProductsBajMin() throws Exception {

         //Get all the products that sol max and min
         List<Product> products = RepositoryFactory.getInstance().getProductsRepository().getAllProductsSolMaxMin();

         //Get the general existence        
         final List<Product> finalProducts = new ArrayList<>();
         for(Product Product_:products){

             //Get the general existence 
             final float generalExistence = this.getGeneralExistenceFromProduct(Product_.getCode());

             final int minimun = Product_.getMinimun();

             //If is under min add it to the result
             if(generalExistence < minimun){
                 finalProducts.add(Product_);
             }
         }                

         //Return the result model
         return finalProducts;
    }

    final public List<Product> getAllProductsBajMinLikeFilter(final String filter) throws Exception {

         final List<Product> products = this.getAllProductsBajMin();

         final List<Product> finalProducts = new ArrayList<>();
         for(Product Product_:products){
             if(Product_.getCode().startsWith(filter)){
                 finalProducts.add(Product_);
             }
         }

         return finalProducts;
    }

    final public List<Product> getAllProductsUpMax() throws Exception {

         //Get all the products that sol max and min
         List<Product> products = RepositoryFactory.getInstance().getProductsRepository().getAllProductsSolMaxMin();

         //Get the general existence        
         final List<Product> finalProducts = new ArrayList<>();
         for(Product Product_:products){

             //Get the general existence 
             final float generalExistence = this.getGeneralExistenceFromProduct(Product_.getCode());

             final int maximum = Product_.getMaximum();

             //If is under min add it to the result
             if(generalExistence > maximum){
                 finalProducts.add(Product_);
             }
         }                

         //Return the result model
         return finalProducts;
    }


    final public List<Product> getAllProductsUpMaxLikeFilter(final String filter) throws Exception {

         final List<Product> products = this.getAllProductsUpMax();

         final List<Product> finalProducts = new ArrayList<>();
         for(Product Product_:products){
             if(Product_.getCode().startsWith(filter)){
                 finalProducts.add(Product_);
             }
         }

         return finalProducts;
    }

    final public float getGeneralExistenceFromProduct(final String productCode) throws Exception {

         //Open database
         openDatabase();

         String hql = "FROM Existalma where prod = :productCode";
         Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);        
         query.setParameter("productCode", productCode);
         List<Existalma> almas = query.list();

         //Close database        
         closeDatabase();

         //Get the general existence
         float existente = 0;
         for(Existalma Existalma_:almas){
             existente += Existalma_.getExist();
         }                

         //Return the result model
         return existente;
    }

    final public List<Existalma> getAllWarehousesExistencesByProduct(final String productCode) throws Exception {

         //Open database
         openDatabase();

         String hql = "FROM Existalma where prod = :productCode";
         Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);        
         query.setParameter("productCode", productCode);
         List<Existalma> Existalma = query.list();

         //Close database        
         closeDatabase();

         //Return the result model
         return Existalma;
    }

    @Override
    final public List<Existalma> getByLikeEncabezados(final String search) throws Exception {

        final List<String> likes = new ArrayList<>();
        likes.add("falt");
        likes.add("fmod");

        final List<Existalma> records = (List<Existalma>) this.getAllLike(likes, search);

        return records;
    }
}