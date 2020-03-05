
import com.era.logger.LoggerUtility;
import com.era.models.BasDats;
import com.era.models.License;
import com.era.repositories.BasDatsRepository;
import com.era.repositories.RepositoryManager;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.classic.Session;
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
public class BasDatsJUnitTest  {
    
    @Test
    @Order(1)
    public void addBasDatsTest() {
        
        /*BasDats BasDats = new BasDats();
        BasDats.setCompanyCode("TESTCOMPANY01");
        BasDats.setDatabase("testdb");
        
        try{
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Adding basdats " + BasDats);
            
            RepositoryManager.getInstance().getBasDatsRepository().save(BasDats);
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Added");
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Method returned " + BasDats);
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Success");
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Failed");
        }    */        
    }
    
    @Test
    @Order(2)
    public final void getByCompanyCodeTest(){
        
        try{
            
            final String companyCode = "TESTCOMPANY01";
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Getting basdats by company code: " + companyCode);
            
            BasDats BasDats = RepositoryManager.getInstance().getBasDatsRepository().getByCompanyCode(companyCode);
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Got " + BasDats);
            
            assertNotNull(BasDats);
        
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Success");
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Failed");
        }        
    }
    
    @Test
    @Order(3)
    public final void deleteBasdatsTest(){
        
        try{
            
            final String companyCode = "TESTCOMPANY01";
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Deleting basdats by comapny code: " + companyCode);
            
            RepositoryManager.getInstance().getBasDatsRepository().deleteBasDats(companyCode);
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Deleted");
            
            BasDats BasDats = RepositoryManager.getInstance().getBasDatsRepository().getByCompanyCode("TESTCOMPANY01");
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Validating if effectively the model was removed BasDats = " + BasDats);
            
            assertNull(BasDats);
        
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Success");
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Failed");
        }
    }
    
    @Test
    @Order(4)
    public void addBasDatsWithTransactionTest() throws Exception {
        
        //Open database
        /*final Session session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        session.beginTransaction();
        
        //Create license
        License License = new License();
        License.setUser("TESTUSER");
        License.setPassword("PASSWORDTEST");
        License.setUsers(10);
        License.setServerDate("10-10-2019");
        
        //Save the licence
        session.save(License);
        
        BasDats BasDats = new BasDats();
        BasDats.setCompanyCode("TESTCOMPANY01");
        BasDats.setDatabase("testdb");
        
        try{
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Adding basdats " + BasDats);
            
            final BasDatsRepository BasDatsRepository = RepositoryManager.getInstance().getBasDatsRepository();
            BasDatsRepository.setSession(session);
            BasDatsRepository.save(BasDats);
            
            RepositoryManager.getInstance().getBasDatsRepository().save(BasDats);
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Added");
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Method returned " + BasDats);
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Success");
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
            
            LoggerUtility.getSingleton().logInfo(CompanyJUnitTest.class, "Failed");
            
        }finally{
            
            //Close database
            session.getTransaction().commit();
            HibernateUtil.getSingleton().shutdown();
        }*/
    }
}
