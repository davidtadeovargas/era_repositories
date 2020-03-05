
import com.era.logger.LoggerUtility;
import com.era.models.Company;
import com.era.repositories.RepositoryManager;
import com.era.repositories.models.HibernateConfigModel;
import com.era.repositories.utils.HibernateConfigUtil;
import com.era.repositories.utils.HibernateSchemeUtil;
import com.era.repositories.utils.HibernateUtil;
import com.era.repositories.utils.MysqlScriptsUtil;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
public class HibernateUtilJUnitTest  {
    
    /*@Test
    @Order(1)
    public void getHibernateConfigFileTest() {
        
        try{
            
            //Connect the connections params to hibernate
            HibernateConfigModel HibernateConfigModel = new HibernateConfigModel();
            HibernateConfigModel.setUser("root");
            HibernateConfigModel.setPassword("a5z8y1Tadeo");
            HibernateConfigModel.setPort(3306);
            HibernateConfigModel.setInstance("localhost");
            HibernateConfigModel.setDatabase("dbempresas");
            
            HibernateUtil.setHibernateConfigModel(HibernateConfigModel);
            
            final SessionFactory SessionFactory = HibernateUtil.getSessionFactory();
            
            final Session Session = SessionFactory.openSession();
            
            Session.beginTransaction();
            
            assertTrue(true);
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(HibernateConfigJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }*/
    
    /*@Test
    @Order(2)
    public void getAnnotationConfigurationTest() {
        
        try{
            
            final AnnotationConfiguration AnnotationConfiguration = HibernateUtil.getSingleton().getAnnotationConfiguration();
            
            assertNotNull(AnnotationConfiguration);
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(HibernateConfigJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }*/
    
    @Test
    @Order(2)
    public void getAnnotationConfigurationTest() {
        
        try{
            
            HibernateConfigModel HibernateConfigModel = new HibernateConfigModel();
            HibernateConfigModel.setDatabase("testsss");
            HibernateConfigModel.setInstance("localhost");
            HibernateConfigModel.setPassword("a5z8y1Tadeo");
            HibernateConfigModel.setUser("root");
            HibernateConfigModel.setPort(3306);
            
            HibernateUtil.getSingleton().setHibernateConfigModel(HibernateConfigModel);
            
            MysqlScriptsUtil.getInstance().creaDBJDBC(HibernateConfigModel.getDatabase(), HibernateConfigModel.getUser(), HibernateConfigModel.getPassword(), HibernateConfigModel.getInstance(), 3306);
            
            HibernateUtil.getSingleton().buildSessionFactoryFromHibernateConfigModelCreate(HibernateConfigModel);
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(HibernateConfigJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }
}
