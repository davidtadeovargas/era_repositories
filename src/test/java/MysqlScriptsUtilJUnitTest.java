
import com.era.logger.LoggerUtility;
import com.era.models.Company;
import com.era.repositories.utils.MysqlScriptsUtil;
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
public class MysqlScriptsUtilJUnitTest  {
    
    /*@Test
    @Order(1)
    public void getMySQLPATHTest() {
                
        try{
            
            final String result = MysqlScriptsUtil.getInstance().getMySQLPATH("root", "a5z8y1Tadeo", "localhost", 3306);
            
            assertNotNull(result);
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }
    
    @Test
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
