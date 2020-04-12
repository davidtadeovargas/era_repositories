
import com.era.logger.LoggerUtility;
import com.era.models.PushNotification;
import com.era.repositories.RepositoryFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import org.junit.jupiter.api.Assertions;
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
public class PushNotificationJUnitTest  {
    
    @Test
    @Order(1)
    public final void newNotificationTest(){
        
        try{
            
            final PushNotification PushNotification = RepositoryFactory.getInstance().getPushNotificationsRepository().newNotification("Test message", "C:\\WinNMP\\WWW\\era\\public\\banners\\39775dfaba31615d95.45523463.png","google.com");
            
            final PushNotification PushNotification_ = (PushNotification) RepositoryFactory.getInstance().getPushNotificationsRepository().getByID(PushNotification.getId());
        
            RepositoryFactory.getInstance().getPushNotificationsRepository().deleteById(PushNotification_.getId());
            
            Assertions.assertNotNull(PushNotification_);
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }        
    }
    
    @Test
    @Order(2)
    public final void getTodayNotifications(){
        
        try{
            
            //Insert 3 records
            RepositoryFactory.getInstance().getPushNotificationsRepository().newNotification("Today", "C:\\WinNMP\\WWW\\era\\public\\banners\\39775dfaba31615d95.45523463.png","google.com");
            RepositoryFactory.getInstance().getPushNotificationsRepository().newNotification("Today", "C:\\WinNMP\\WWW\\era\\public\\banners\\39775dfaba31615d95.45523463.png","google.com");
            RepositoryFactory.getInstance().getPushNotificationsRepository().newNotification("Today", "C:\\WinNMP\\WWW\\era\\public\\banners\\39775dfaba31615d95.45523463.png","google.com");
            
            //Insert 3 records for the month
            RepositoryFactory.getInstance().getPushNotificationsRepository().newNotification("Month", "C:\\WinNMP\\WWW\\era\\public\\banners\\39775dfaba31615d95.45523463.png","google.com");
            RepositoryFactory.getInstance().getPushNotificationsRepository().newNotification("Month", "C:\\WinNMP\\WWW\\era\\public\\banners\\39775dfaba31615d95.45523463.png","google.com");
            RepositoryFactory.getInstance().getPushNotificationsRepository().newNotification("Month", "C:\\WinNMP\\WWW\\era\\public\\banners\\39775dfaba31615d95.45523463.png","google.com");
            
            String query = "UPDATE push_notifications SET created = TIMESTAMPADD(MONTH,1,DATE(created)) WHERE message = 'Month'";
            String sCon = "jdbc:mysql://localhost:3306/dbempresas?user=root&password=a5z8y1Tadeo&verifyServerCertificate=false&useSSL=false";
            try(Connection conn = DriverManager.getConnection(sCon)){
                Statement st = conn.createStatement();
                st.executeUpdate(query);
            }

            final List<PushNotification> PushNotification = RepositoryFactory.getInstance().getPushNotificationsRepository().getTodayNotifications();
            
            LoggerUtility.getSingleton().logInfo(PushNotificationJUnitTest.class, "Tests: Returned size push notifications " + PushNotification.size());
                        
            try(Connection conn = DriverManager.getConnection(sCon)){                
                Statement st = conn.createStatement();
                query = "DELETE FROM push_notifications WHERE message = 'Month'";
                st.executeUpdate(query);
                query = "DELETE FROM push_notifications WHERE message = 'Today'";
                st.executeUpdate(query);
            }
            
            Assertions.assertTrue(PushNotification.size()==3);
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }
    }
    
    @Test
    @Order(3)
    public final void getMonthNotificationsTest(){
        
        try{
            
            //Insert 3 records
            RepositoryFactory.getInstance().getPushNotificationsRepository().newNotification("Today", "C:\\WinNMP\\WWW\\era\\public\\banners\\39775dfaba31615d95.45523463.png","google.com");
            RepositoryFactory.getInstance().getPushNotificationsRepository().newNotification("Today", "C:\\WinNMP\\WWW\\era\\public\\banners\\39775dfaba31615d95.45523463.png","google.com");
            RepositoryFactory.getInstance().getPushNotificationsRepository().newNotification("Today", "C:\\WinNMP\\WWW\\era\\public\\banners\\39775dfaba31615d95.45523463.png","google.com");
            
            //Insert more records for the month
            RepositoryFactory.getInstance().getPushNotificationsRepository().newNotification("Month", "C:\\WinNMP\\WWW\\era\\public\\banners\\39775dfaba31615d95.45523463.png","google.com");
            RepositoryFactory.getInstance().getPushNotificationsRepository().newNotification("Month", "C:\\WinNMP\\WWW\\era\\public\\banners\\39775dfaba31615d95.45523463.png","google.com");
            RepositoryFactory.getInstance().getPushNotificationsRepository().newNotification("Month", "C:\\WinNMP\\WWW\\era\\public\\banners\\39775dfaba31615d95.45523463.png","google.com");
            RepositoryFactory.getInstance().getPushNotificationsRepository().newNotification("Month", "C:\\WinNMP\\WWW\\era\\public\\banners\\39775dfaba31615d95.45523463.png","google.com");
            RepositoryFactory.getInstance().getPushNotificationsRepository().newNotification("Month", "C:\\WinNMP\\WWW\\era\\public\\banners\\39775dfaba31615d95.45523463.png","google.com");
            
            String query = "UPDATE push_notifications SET created = TIMESTAMPADD(MONTH,1,DATE(created)) WHERE message = 'Month'";
            String sCon = "jdbc:mysql://localhost:3306/dbempresas?user=root&password=a5z8y1Tadeo&verifyServerCertificate=false&useSSL=false";
            try(Connection conn = DriverManager.getConnection(sCon)){
                Statement st = conn.createStatement();
                st.executeUpdate(query);
            }

            final List<PushNotification> PushNotification = RepositoryFactory.getInstance().getPushNotificationsRepository().getMonthNotifications();
            
            LoggerUtility.getSingleton().logInfo(PushNotificationJUnitTest.class, "Tests: Returned size push notifications " + PushNotification.size());
                        
            try(Connection conn = DriverManager.getConnection(sCon)){                
                Statement st = conn.createStatement();
                query = "DELETE FROM push_notifications WHERE message = 'Month'";
                st.executeUpdate(query);
                query = "DELETE FROM push_notifications WHERE message = 'Today'";
                st.executeUpdate(query);
            }
            
            Assertions.assertTrue(PushNotification.size()==3);
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }
    }
}
