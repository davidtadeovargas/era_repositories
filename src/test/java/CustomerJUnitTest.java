
import com.era.logger.LoggerUtility;
import com.era.models.Company;
import com.era.repositories.RepositoryFactory;
import java.util.List;
import org.junit.jupiter.api.Assertions;
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
public class CustomerJUnitTest  {
    
    /*@Test
    @Order(1)
    public final void addCustomerTest(){
        
        try{
            
            Customer Customer = new Customer();
            Customer.setCode("CLI1");
            Customer.setCompanyCode("CLI1");
            Customer.setSerie("CL");
            Customer.setName("Test company");
            Customer.setPhone("323232");
            Customer.setStreet("Rio altar");
            Customer.setColony("Colonia atlas");
            Customer.setCURP("VAVY910708LNA");
            Customer.setCP("44150");
            Customer.setCity("GUADALAJARA");
            Customer.setEstate("JALISCO");
            Customer.setCountry("MEXICO");
            Customer.setRFC("VACY910789A9");
            Customer.setWebpage1("www.google.com");
            Customer.setInteriorNumber("10");
            Customer.setExternalNumber("1515");
            Customer.setList(1);
            Customer.setEstac("ESTAC1");
            Customer.setSucu("SUC1");
            Customer.setNocaj("CAJ1");
            
            Customer = RepositoryManager.getInstance().getCustomersRepository().addCustomer(Customer);
                
             assertNotNull(Customer);
        
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CustomerJUnitTest.class, e);
            
            Assertions.fail();
        }
    }*/
    
    @Test
    @Order(2)
    public final void deleteCustomerTest(){
        
        try{
            
            Company Company = RepositoryFactory.getInstance().getCompanyRepository().getCustomerByCode("CLI1");
            
            RepositoryFactory.getInstance().getCompanyRepository().deleteById(Company.getId());
                
            Company = RepositoryFactory.getInstance().getCompanyRepository().getCustomerByCode("CLI1");
            
            assertNull(Company);
        
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CustomerJUnitTest.class, e);
            
            Assertions.fail();
        }
    }
    
    @Test
    @Order(3)
    public final void getAllCustomers(){
        
        try{
            
            List<Company> Customers = (List<Company>) RepositoryFactory.getInstance().getCompanyRepository().getAll();
            
            if(Customers.size()>0){
                Assertions.assertTrue(true);
            }
            else{
                Assertions.assertFalse(false);
            }
                        
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CustomerJUnitTest.class, e);
            
            Assertions.fail();
        }
    }
}
