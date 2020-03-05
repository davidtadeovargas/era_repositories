
import com.era.logger.LoggerUtility;
import com.era.models.Product;
import com.era.repositories.RepositoryManager;
import com.era.repositories.models.HibernateConfigModel;
import com.era.repositories.utils.HibernateUtil;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author PC
 */
@TestMethodOrder(OrderAnnotation.class)
public class ProductJUnitTest  {
    
    /*@Test
    @Order(1)
    public final void getProductByIDTest(){
        
        try{
            
            final HibernateConfigModel HibernateConfigModel = new HibernateConfigModel();
            HibernateConfigModel.setDatabase("TESTERA_5e1a153f2b4a9");
            HibernateConfigModel.setInstance("localhost");
            HibernateConfigModel.setPassword("a5z8y1Tadeo");
            HibernateConfigModel.setPort(3306);
            HibernateConfigModel.setUser("root");
            
            HibernateUtil.setHibernateConfigModel(HibernateConfigModel);
            
            Product Product = RepositoryManager.getInstance().getProductRepository().getProductByID(1);
            
            Assertions.assertNotNull(Product);
        
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(ProductJUnitTest.class, e);
            
            Assertions.fail();
        }        
    }
    
    @Test
    @Order(2)
    public void getProductByCodeTest() {
                
        try{
            
            final HibernateConfigModel HibernateConfigModel = new HibernateConfigModel();
            HibernateConfigModel.setDatabase("TESTERA_5e1a153f2b4a9");
            HibernateConfigModel.setInstance("localhost");
            HibernateConfigModel.setPassword("a5z8y1Tadeo");
            HibernateConfigModel.setPort(3306);
            HibernateConfigModel.setUser("root");
            
            HibernateUtil.setHibernateConfigModel(HibernateConfigModel);
            
            Product Product = RepositoryManager.getInstance().getProductRepository().getProductByCode("110120121328");
            
            Assertions.assertNotNull(Product);
            
            assertNotNull(Product);
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }        
    
    @Test
    @Order(3)
    public final void addOrUpdateProductTest(){
        
        try{
            
            Product Product = new Product(); //92
            Product.setCodeProduct("prod");
            Product.setCodeProductOptional1("prodop1");
            Product.setCodeProductOptional2("prodop2");
            Product.setProviderOptional1("provop1");
            Product.setProviderOptional2("provop2");            
            Product.setCodeMeasure("codmed");
            Product.setWarranty("garan");
            Product.setClassJerarchy("clasjera");
            Product.setDescription("descrip");
            Product.setShortDescription("descripcort");
            Product.setCodeLine("lin");
            Product.setCostMethod("metcost");
            Product.setTip("tip");
            Product.setAskMaxMin(0);
            Product.setBrand("marc");
            Product.setCodeUbication("codubi");
            Product.setModel("mode");
            Product.setMaker("fab");
            Product.setColor("colo");
            Product.setAskSerie(true);
            Product.setCodeExtra("codext");
            Product.setSerialNumber("noser");
            Product.setComentSerial("comenser");
            Product.setPathIMG("rutimg");
            Product.setCodeTax("impue");
            Product.setWeight("pes");
            Product.setWeightMan(2);
            Product.setPriceList1(3);
            Product.setPriceList2(4);
            Product.setPriceList3(5);
            Product.setPriceList4(6);
            Product.setPriceList5(7);
            Product.setPriceList6(8);
            Product.setPriceList7(9);
            Product.setPriceList8(10);
            Product.setPriceList9(11);
            Product.setPriceList10(12);
            Product.setUtilSales1(13);
            Product.setUtilSales2(14);
            Product.setUtilSales3(15);
            Product.setUtilSales4(16);
            Product.setUtilSales5(17);
            Product.setUtilSales6(18);
            Product.setUtilSales7(19);
            Product.setUtilSales8(20);
            Product.setUtilSales9(21);
            Product.setUtilSales10(22);
            Product.setMeasure(23);
            Product.setCost(24);
            Product.setRecolectionCost(25);
            Product.setExistence(0);
            Product.setUnit("unid");
            Product.setShelf("anaq");
            Product.setPlace("lug");
            Product.setWharehouse("alma");
            Product.setDiscountProvider("descprov");
            Product.setInformation("infor");
            Product.setMinimun(26);
            Product.setMaximum(27);
            Product.setLowerCost(28);
            Product.setIsForSale(29);
            Product.setCompound(30);
            Product.setIventory(31);
            Product.setCompanyID("idempresa");
            Product.setEstation("estac");
            Product.setCreationStation("estaccrea");
            Product.setBranchOffice("sucu");
            Product.setNumberCash("nocaj");
            Product.setLot("lote");
            Product.setPediment("pedimen");
            Product.setService(true);
            Product.setLotPediment(true);
            Product.setExport(true);
            Product.setExtra1("extr1");
            Product.setExtra2("extr2");
            Product.setExtra3("extr3");
            Product.setExpirationDate(new Date());
            Product.setCreationDate(new Date());
            Product.setModificationDate(new Date());
            Product.setKeySAT("clavesat");
            Product.setPrincipalProvider(35);
            Product.setWarrantyID(36);
            Product.setLineID(37);
            Product.setTypeID(38);
            Product.setBrandID(39);
            Product.setModelID(40);
            Product.setMakerID(41);
            Product.setColorID(42);
            Product.setWeightID(43);
            Product.setUnitID(44);
            Product.setPlaceID(45);
            Product.setWarehouseID(46);
            
            RepositoryManager.getInstance().getProductRepository().addOrUpdateProduct(Product);
            
            Product = RepositoryManager.getInstance().getProductRepository().getProductByCode("prod");
            
            Assertions.assertNotNull(Product);
        
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }
    }
    
    @Test
    @Order(4)
    public final void deleteProductByIdTest(){
        
        try{
            
            RepositoryManager.getInstance().getProductRepository().deleteProduct(7);
            
            Product Product = RepositoryManager.getInstance().getProductRepository().getProductByID(7);
                
            assertNull(Product);
        
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }
    }*/
    
    
    @Test
    @Order(5)
    public final void addMinimumProductTest(){
        
        try{
            
            final HibernateConfigModel HibernateConfigModel = new HibernateConfigModel();
            HibernateConfigModel.setDatabase("TESTERA_5e1a153f2b4a9");
            HibernateConfigModel.setInstance("localhost");
            HibernateConfigModel.setPassword("a5z8y1Tadeo");
            HibernateConfigModel.setPort(3306);
            HibernateConfigModel.setUser("root");            
            
            HibernateUtil.getSingleton().setHibernateConfigModel(HibernateConfigModel);
            
            Product Product = new Product(); //92
            Product.setCodeProduct("prod2");
            Product.setKeySAT("clavesat");
            Product.setUnit("unid");
            Product.setCodeTax("impue");
            Product.setDescription("descrip");
            Product.setEstation("ESTAC1");
            Product.setBranchOffice("SUC1");
            Product.setNumberCash("CAJ1");
            
            RepositoryManager.getInstance().getProductRepository().addOrUpdateProduct(Product);
            
            Product = RepositoryManager.getInstance().getProductRepository().getProductByCode("prod2");
            
            Assertions.assertNotNull(Product);
        
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }
    }
    
    @Test
    @Order(6)
    public final void deleteProductByCodeTest(){
        
        try{
            
            RepositoryManager.getInstance().getProductRepository().deleteProductByCode("prod2");
            
            Product Product = RepositoryManager.getInstance().getProductRepository().getProductByCode("prod2");
                
            assertNull(Product);
        
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }
    }
}
