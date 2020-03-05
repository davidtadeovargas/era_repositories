
import com.era.logger.LoggerUtility;
import com.era.models.Company;
import com.era.repositories.RepositoryManager;
import com.era.repositories.models.HibernateConfigModel;
import com.era.repositories.utils.HibernateConfigUtil;
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
public class HibernateConfigJUnitTest  {
    
    @Test
    @Order(1)
    public void getHibernateConfigFileTest() {
        
        try{
            final HibernateConfigModel HibernateConfigModel = HibernateConfigUtil.getInstance().getHibernateConfigFile();
            
            assertNotNull(HibernateConfigModel);
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(HibernateConfigJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }
}
