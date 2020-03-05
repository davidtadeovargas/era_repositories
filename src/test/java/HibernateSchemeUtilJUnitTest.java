
import com.era.logger.LoggerUtility;
import com.era.repositories.utils.HibernateSchemeUtil;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.cfg.AnnotationConfiguration;
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
public class HibernateSchemeUtilJUnitTest  {
    
    @Test
    @Order(1)
    public void getDescripColumnLengthTest() {
        
        try{
            
            int max = HibernateSchemeUtil.getSingleton().getProductScheme().getDescripColumnLength();
            
            Assertions.assertTrue(max==1000);
            
        }catch(Exception e){
            
            LoggerUtility.getSingleton().logError(HibernateConfigJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }    
}
