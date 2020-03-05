
import com.era.logger.LoggerUtility;
import com.era.models.License;
import com.era.repositories.RepositoryManager;
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
public class LicenseJUnitTest  {
    
    @Test
    @Order(1)
    public final void getLicenseTest(){
        
        try{
            
            License License = RepositoryManager.getInstance().getLicenseRepository().getLicense();
            
            Assertions.assertTrue(true);
        
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }        
    }
    
    @Test
    @Order(2)
    public void addOrUpdateLicenseTest() {
                
        try{
            
            License License = new License(); 
            License.setUser("coritocorito@hotmail.com");
            License.setPassword("123");
            
            RepositoryManager.getInstance().getLicenseRepository().addLicense(License);
            
            final License License_ = RepositoryManager.getInstance().getLicenseRepository().getLicense();
            
            assertNotNull(License_);
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }        
    
    @Test
    @Order(3)    
    public final void existsLicenseTest(){
        
        try{
            
            final boolean exists = RepositoryManager.getInstance().getLicenseRepository().existsLicense();
            
            final License License = RepositoryManager.getInstance().getLicenseRepository().getLicense();
            
            if(License!=null && exists){
                Assertions.assertTrue(true);
            }
            else{
                Assertions.assertFalse(false);
            }
        
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }
    }
    
    @Test
    @Order(4)
    public final void deleteLicenseTest(){
        
        try{
            
            RepositoryManager.getInstance().getLicenseRepository().deleteLicense();
            
            final License License = RepositoryManager.getInstance().getLicenseRepository().getLicense();
                
            assertNull(License);
        
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }
    }
}
