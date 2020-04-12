
import com.era.logger.LoggerUtility;
import com.era.models.Company;
import com.era.repositories.RepositoryFactory;
import org.junit.jupiter.api.Assertions;
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
public class CompanyJUnitTest  {
    
    /*@Test
    @Order(1)
    public void addCompanyTest() {
        
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
        
        try{
            
            Company = RepositoryManager.getInstance().getCompanyRepository().addCompany(Company);
            
            assertNotNull(Company);
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }
    
    @Test
    @Order(2)
    public final void getByCompanyCodeTest(){
        
        try{
            
            Company Company = RepositoryManager.getInstance().getCompanyRepository().getByCompanyCode("TESTES001");
            assertNotNull(Company);
        
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }        
    }
    
    @Test
    @Order(3)
    public final void deleteCompanyTest(){
        
        try{
            
            Company Company = RepositoryManager.getInstance().getCompanyRepository().deleteCompany("TESTES001");
            assertNotNull(Company);
        
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }
    }*/
    
    /*@Test
    @Order(4)
    public void addCompanyInDiferentDatabaseTest() {
        
        Company Company = new Company();
        Company.setCode("TESTES001");
        Company.setName(Long.toString(System.currentTimeMillis()));
        Company.setNameDB("testera_5e002ad81cd65");
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
        
        try{
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Inserting into database " + Company.getNameDB());
            
            //Company = RepositoryManager.getInstance().getCompanyRepository().addCompanyInDiferentDatabase(Company, Company.getNameDB());
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Returned " + Company);
            
            assertNotNull(Company);
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }*/
}
