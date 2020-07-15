
import com.era.logger.LoggerUtility;
import com.era.models.Company;
import com.era.models.Consec;
import com.era.models.DocumentOrigin;
import com.era.models.Partvta;
import com.era.models.Sales;
import com.era.models.User;
import com.era.repositories.RepositoryFactory;
import com.era.repositories.SalessRepository;
import com.era.repositories.models.HibernateConfigModel;
import com.era.repositories.utils.HibernateUtil;
import com.era.repositories.utils.MysqlScriptsUtil;
import com.era.utilities.ConfigFileUtil;
import com.era.utilities.UtilitiesFactory;
import com.era.utilities.models.ConfigFileModel;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
public class SalesGeneratorJUnitTest  {
    
    /*@Test
    @Order(1)
    public void createRandomSalesTest() {
                
        try{
                        
            //Get the configuration connection params
            ConfigFileModel ConfigFileModel;
            ConfigFileModel = ConfigFileUtil.getSingleton().getConfigFileModel();

            final String instance = ConfigFileModel.getInstance();
            final String user = ConfigFileModel.getUser();
            final String password = ConfigFileModel.getPassword();
            final String db = ConfigFileModel.getDb();
            final String port = ConfigFileModel.getPort();

            //Save dbempresas params connection to hibernate config file
            final HibernateConfigModel HibernateConfigModel_ = new HibernateConfigModel();
            HibernateConfigModel_.setUser(user);        
            HibernateConfigModel_.setPassword(password);
            HibernateConfigModel_.setPort(Integer.valueOf(port));
            HibernateConfigModel_.setInstance(instance);
            HibernateConfigModel_.setDatabase(db);
            HibernateUtil.getSingleton().setHibernateConfigModelDbEmpresas(HibernateConfigModel_);

            HibernateUtil.getSingleton().useDbEmpresas();
            
            //Create the hibernate config model connection file                
            final HibernateConfigModel HibernateConfigModel = HibernateUtil.getSingleton().createLocalHibernateConfigModel("era_db_test");

            //Save the local connections param
            HibernateUtil.getSingleton().setHibernateConfigModelLocal(HibernateConfigModel);

            //Load the local factory
            HibernateUtil.getSingleton().loadDbLocal();
            
            final User User = new User();
            User.setCode("SUP");
            User.setSucu("INICIAL");
            User.setNocaj("INICIAL");
            
            UtilitiesFactory.getSingleton().getSessionUtility().userInitSession(User);
            
            final int totalSales = 70000;
            
            //Create all the test sales
            final SalessRepository SalessRepository = RepositoryFactory.getInstance().getSalessRepository();
            for(int x = 0; x < totalSales;x++){
                
                System.out.println("Inserting sale number " + x);
                
                final List<Partvta> items = new ArrayList<>();
                final Partvta Partvta = new Partvta();
                Partvta.setAlma("SYS");
                Partvta.setMon("PESOS");
                Partvta.setCant(BigDecimal.ONE);
                Partvta.setDescrip("Papas sabritas 500gm");
                Partvta.setEskit(false);
                Partvta.setList(1);
                Partvta.setPre(BigDecimal.TEN);
                Partvta.setTipcam(BigDecimal.ONE);
                Partvta.setUnid("PIEZA");
                Partvta.setImpo(BigDecimal.TEN);
                Partvta.setImpue(0);
                Partvta.setProd("SABRI500");
                Partvta.setDescu(BigDecimal.ZERO);
                items.add(Partvta);

                //Get ticket consec
                final Consec Consec = (Consec)RepositoryFactory.getInstance().getConsecsRepository().getTicketsConsec("TIK");
                
                //Get the document type
                final DocumentOrigin DocumentOrigin = RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentOriginTIK();
                
                final Sales Sales = new Sales();
                Sales.setCompanyCode("EMPMOS");
                Sales.setRazon("PUBLICO GENERAL");
                Sales.setSubtotal(BigDecimal.TEN);
                Sales.setTax(BigDecimal.TEN);
                Sales.setTotal(BigDecimal.TEN);
                Sales.setAccount("");
                Sales.setReferenceNumber(String.valueOf(Consec.getConsec()));
                Sales.setSerie("");
                Sales.setNoser("");
                Sales.setCoinCode("PESOS");
                Sales.setSalesMan("SUP");
                Sales.setPaymentForm("01");
                Sales.setTypeExchange(BigDecimal.ONE);
                Sales.setTotalTranslade(BigDecimal.TEN);
                Sales.setTotalRetention(BigDecimal.TEN);
                Sales.setDocumentType(DocumentOrigin.getType());
                Sales.setPaymentMethod("01");
                Sales.setEmisionDate(UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDate());
                Sales.setDeliverDate(UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDate());
                Sales.setTicket(true);
                Sales.setEstatus("CO");
                Sales.setObservation("");

                SalessRepository.saveSale(Sales, items, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
            }
            
            System.out.println("Finished inserting sales " + totalSales);
            
            Assertions.assertTrue(true);
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(this.getClass(), e);
            
            Assertions.fail();
        }            
    }*/
    
    /*@Test
    @Order(2)
    public void creaDBDBEmpresasTest() {
                
        try{
            
            final int result = MysqlScriptsUtil.getInstance().creaDBDBEmpresas("root", "a5z8y1Tadeo", "localhost", 3306);
            
            assertEquals(0,result);
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }
    
    @Test
    @Order(3)
    public void creaDBTest() {
                
        try{
            
            Company Company = new Company();
            Company.setCode("TESTES001");
            Company.setName(Long.toString(System.currentTimeMillis()));
            Company.setNameDB("dbtest100");
            Company.setMetcost("ueps");
            Company.setPhone("33151064492");
            Company.setStreet("mi calle");
            Company.setNumint("-12");
            Company.setNumext("100");
            Company.setColony("ATLAS");
            Company.setCity("GUADALAJARA");
            Company.setEstate("JALISCO");
            Company.setCountry("MEXICO");
            Company.setRfc(Long.toString(System.currentTimeMillis()));
            Company.setEmail("coritocorito@hotmail.com");
            Company.setWebsite("www.google.com");
            Company.setContribuyentType("");
            Company.setExpeditionPlace("GUADALAJARA");
            Company.setFiscalRegimen("");
            Company.setCertificatePath("");
            Company.setKeyPath("");
            Company.setCertificatePassword("");
            Company.setCp("100");
            Company.setTemplate("");
            Company.setAppPath("");
            Company.setSucursal("SUC1");
            Company.setExtension("1001");
            Company.setCashName("CAJ1");
            Company.setTest(false);
            
            final int result = MysqlScriptsUtil.getInstance().creaDB(Company,"root", "a5z8y1Tadeo", "localhost", 3306);
            
            assertEquals(0,result);
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }
    
    @Test
    @Order(4)
    public void existsDBEmpresasDatabaseTest() {
                
        try{
            
            final boolean result = MysqlScriptsUtil.getInstance().existsDBEmpresasDatabase("root", "a5z8y1Tadeo", "localhost", 3306);
                        
            Assertions.assertFalse(result);
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }
    
    
    @Test
    @Order(5)
    public void existsTrueDBEmpresasDatabaseTest() {
                
        try{
            
            final boolean result = MysqlScriptsUtil.getInstance().existsDBEmpresasDatabase("root", "a5z8y1Tadeo", "localhost", 3306);
                        
            Assertions.assertTrue(result);
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }        */
}
