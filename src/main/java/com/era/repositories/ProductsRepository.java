package com.era.repositories;

import com.era.logger.LoggerUtility;
import com.era.models.ImpuesXProduct;
import com.era.models.Kits;
import com.era.models.Product;
import com.era.models.Tax;
import com.era.repositories.models.ProductPriceListModel;
import com.era.repositories.utils.HibernateUtil;
import com.era.utilities.UtilitiesFactory;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class ProductsRepository extends Repository {

    public ProductsRepository() {
        super(Product.class);
    }
   
    @Override
    public List<?> getAllByPageWithSearchFilter(final String search, final int pageNumber, int pageSize) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);       
        
        final Session Session = HibernateUtil.getSingleton().getSession();
        
        String hql = "FROM Product WHERE code LIKE:code OR description LIKE:description OR shortDescription LIKE:shortDescription";
        Query query = Session.createQuery(hql);
        query.setParameter("code", "%" + search + "%");
        query.setParameter("description", "%" + search + "%");
        query.setParameter("shortDescription", "%" + search + "%");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);        
        List<?> records = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return records;
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
    
    public BigDecimal getTotalTaxesOfProduct(final String productCode, final BigDecimal import_) throws Exception {
        
        //Get the taxes of the product
        final List<ImpuesXProduct> taxesProduct = RepositoryFactory.getInstance().getImpuesXProductRepository().getAllByProd(productCode);

        BigDecimal taxes = BigDecimal.ZERO;
        
        //Iterate over all the taxes to calculate to taxes total
        for(ImpuesXProduct ImpuesXProduct: taxesProduct){
            final String taxCode = ImpuesXProduct.getImpue();
            final Tax Tax = (Tax)RepositoryFactory.getInstance().getTaxesRepository().getByCode(taxCode);
            final double tax = Tax.getValue() / 100;
            taxes = taxes.add(import_.multiply(new BigDecimal(tax, MathContext.DECIMAL64)));
        }
        
        return taxes;
    }
    
    final public List<Float> getPriceListsFromProduct(final String codeProduct) throws Exception {
        
        final Product Product = (Product)this.getByCode(codeProduct);
        
        final List<Float> pricesList = new ArrayList<>();
        pricesList.add(Product.getPriceList1());
        pricesList.add(Product.getPriceList2());
        pricesList.add(Product.getPriceList3());
        pricesList.add(Product.getPriceList4());
        pricesList.add(Product.getPriceList5());
        pricesList.add(Product.getPriceList6());
        pricesList.add(Product.getPriceList7());
        pricesList.add(Product.getPriceList8());
        pricesList.add(Product.getPriceList9());
        pricesList.add(Product.getPriceList10());
        
        return pricesList;
                
    }        
    
    final public List<ProductPriceListModel> getPriceListsFromProductToListModel(final String codeProduct) throws Exception {
        
        final Product Product = (Product)this.getByCode(codeProduct);
                
        final List<ProductPriceListModel> pricesListModel = new ArrayList<>();
        
        ProductPriceListModel ProductPriceListModel = new ProductPriceListModel();
        ProductPriceListModel.setProductCode(codeProduct);
        ProductPriceListModel.setPriceList(1);
        ProductPriceListModel.setPrice(Product.getPriceList1());
        pricesListModel.add(ProductPriceListModel);
        ProductPriceListModel = new ProductPriceListModel();
        ProductPriceListModel.setProductCode(codeProduct);
        ProductPriceListModel.setPriceList(2);
        ProductPriceListModel.setPrice(Product.getPriceList2());
        pricesListModel.add(ProductPriceListModel);
        ProductPriceListModel = new ProductPriceListModel();
        ProductPriceListModel.setProductCode(codeProduct);
        ProductPriceListModel.setPriceList(3);
        ProductPriceListModel.setPrice(Product.getPriceList3());
        pricesListModel.add(ProductPriceListModel);
        ProductPriceListModel = new ProductPriceListModel();
        ProductPriceListModel.setProductCode(codeProduct);
        ProductPriceListModel.setPriceList(4);
        ProductPriceListModel.setPrice(Product.getPriceList4());
        pricesListModel.add(ProductPriceListModel);
        ProductPriceListModel = new ProductPriceListModel();
        ProductPriceListModel.setProductCode(codeProduct);
        ProductPriceListModel.setPriceList(5);
        ProductPriceListModel.setPrice(Product.getPriceList5());
        pricesListModel.add(ProductPriceListModel);
        ProductPriceListModel = new ProductPriceListModel();
        ProductPriceListModel.setProductCode(codeProduct);
        ProductPriceListModel.setPriceList(6);
        ProductPriceListModel.setPrice(Product.getPriceList6());
        pricesListModel.add(ProductPriceListModel);
        ProductPriceListModel = new ProductPriceListModel();
        ProductPriceListModel.setProductCode(codeProduct);
        ProductPriceListModel.setPriceList(7);
        ProductPriceListModel.setPrice(Product.getPriceList7());
        pricesListModel.add(ProductPriceListModel);
        ProductPriceListModel = new ProductPriceListModel();
        ProductPriceListModel.setProductCode(codeProduct);
        ProductPriceListModel.setPriceList(8);
        ProductPriceListModel.setPrice(Product.getPriceList8());
        pricesListModel.add(ProductPriceListModel);
        ProductPriceListModel = new ProductPriceListModel();
        ProductPriceListModel.setProductCode(codeProduct);
        ProductPriceListModel.setPriceList(9);
        ProductPriceListModel.setPrice(Product.getPriceList9());
        pricesListModel.add(ProductPriceListModel);
        ProductPriceListModel = new ProductPriceListModel();
        ProductPriceListModel.setProductCode(codeProduct);
        ProductPriceListModel.setPriceList(10);
        ProductPriceListModel.setPrice(Product.getPriceList10());
        pricesListModel.add(ProductPriceListModel);
        
        return pricesListModel;
                
    }
    
    final public boolean hasProductPriceInList(final String codeProduct, final int list) throws Exception {
                        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Product WHERE code = :codeProduct";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("codeProduct", codeProduct);        
        Product Product = query.list().size() > 0 ? (Product) query.list().get(0):null;
                
        boolean hasPrice = false;
        switch(list){
            
            case 1:
                hasPrice = Product.getPriceList1()>0;
                break;
                
            case 2:
                hasPrice = Product.getPriceList2()>0;
                break;
              
            case 3:
                hasPrice = Product.getPriceList3()>0;
                break;
                
            case 4:
                hasPrice = Product.getPriceList4()>0;
                break;
                
            case 5:
                hasPrice = Product.getPriceList5()>0;
                break;
                
            case 6:
                hasPrice = Product.getPriceList6()>0;
                break;
                
            case 7:
                hasPrice = Product.getPriceList7()>0;
                break;
                
            case 8:
                hasPrice = Product.getPriceList8()>0;
                break;
                
            case 9:
                hasPrice = Product.getPriceList9()>0;
                break;
                
            case 10:
                hasPrice = Product.getPriceList10()>0;
                break;
        }
                
        return hasPrice;
    }
    
    final public BigDecimal getPriceList(final String codeProduct, final int list) throws Exception {
                        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Product WHERE code = :codeProduct";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("codeProduct", codeProduct);        
        Product Product = query.list().size() > 0 ? (Product) query.list().get(0):null;
                
        BigDecimal price = BigDecimal.ZERO;
        switch(list){
            
            case 1:
                price = new BigDecimal(String.valueOf(Product.getPriceList1()));
                break;
                
            case 2:
                price = new BigDecimal(String.valueOf(Product.getPriceList2()));
                break;
              
            case 3:
                price = new BigDecimal(String.valueOf(Product.getPriceList3()));
                break;
                
            case 4:
                price = new BigDecimal(String.valueOf(Product.getPriceList4()));
                break;
                
            case 5:
                price = new BigDecimal(String.valueOf(Product.getPriceList5()));
                break;
                
            case 6:
                price = new BigDecimal(String.valueOf(Product.getPriceList6()));
                break;
                
            case 7:
                price = new BigDecimal(String.valueOf(Product.getPriceList7()));
                break;
                
            case 8:
                price = new BigDecimal(String.valueOf(Product.getPriceList8()));
                break;
                
            case 9:
                price = new BigDecimal(String.valueOf(Product.getPriceList9()));
                break;
                
            case 10:
                price = new BigDecimal(String.valueOf(Product.getPriceList10()));
                break;
        }
                
        return price;
    }
    
    final public boolean existsLineInProduct(final String codeLine) throws Exception {
                        
        final List<Product> products = this.getAllByLine(codeLine);
        return products.size()>0;
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

        //Validate that the product is not in any sale
        if(RepositoryFactory.getInstance().getPartvtaRepository().existsProduct(codeProduct)){
            UtilitiesFactory.getSingleton().getGenericExceptionUtil().generateException("errors_product_exists_in_partvta_and_cannot_be_deleted");
        }
        
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
        
    final public List<Product> getByLikeEncabezadosBasic(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");        
        likes.add("description");        
        
        final List<Product> items = (List<Product>) this.getAllLike(likes, search);
        
        return items;
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