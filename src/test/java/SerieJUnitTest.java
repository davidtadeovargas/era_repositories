
import com.era.logger.LoggerUtility;
import com.era.models.Serie;
import com.era.repositories.RepositoryFactory;
import com.era.repositories.SerieRepository;
import com.era.repositories.models.HibernateConfigModel;
import com.era.repositories.utils.HibernateUtil;
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
public class SerieJUnitTest  {
    
    /*@Test
    @Order(1)
    public final void addSerieTest(){
        
        try{
            
            Serie Serie = new Serie();
            Serie.setSerie("TEST");
            Serie.setDescription("Description test");
            Serie.setType("FAC2");
            Serie.setConsecutive(0);
            Serie.setEstation("ESTAC1");
            Serie.setSucursal("SUC1");
            Serie.setCashNumber("CAJ1");
            
            RepositoryManager.getInstance().getSerieRepository().addSerie(Serie);
            
            Serie Serie_ = RepositoryManager.getInstance().getSerieRepository().getBySerie("TEST");
            
            Assertions.assertNotNull(Serie_);
        
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }        
    }
    
    @Test
    @Order(2)
    public void removeSerieTest() {
                
        try{
            
            Serie Serie_ = RepositoryManager.getInstance().getSerieRepository().getBySerie("TEST");            
            
            RepositoryManager.getInstance().getSerieRepository().removeSerie(Serie_.getId());
            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getBySerie("TEST");
            
            assertNull(Serie_);
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }
    
    @Test
    @Order(3)
    public void getFirstSerieByTypeTest() {
                
        try{
            
            //Connect the connections params to hibernate
            HibernateConfigModel HibernateConfigModel = new HibernateConfigModel();
            HibernateConfigModel.setUser("root");
            HibernateConfigModel.setPassword("a5z8y1Tadeo");
            HibernateConfigModel.setPort(3306);
            HibernateConfigModel.setInstance("localhost");
            HibernateConfigModel.setDatabase("testera_5e227b7e30b5c");
            
            HibernateUtil.setHibernateConfigModel(HibernateConfigModel);
            
            Serie Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSeriePREV();            
            if(Serie_.getType().compareTo("PREV")!=0){
                Assertions.fail();
                return;
            }
            
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "PREV found");
            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieNOTC();            
            if(Serie_.getType().compareTo("NOTC")!=0){
                Assertions.fail();
                return;
            }
            
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "NOTC found");
            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieNOTP();            
            if(Serie_.getType().compareTo("NOTP")!=0){
                Assertions.fail();
                return;
            }
            
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "NOTP found");
            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieFAC();            
            if(Serie_.getType().compareTo("FAC")!=0){
                Assertions.fail();
                return;
            }
            
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "FAC found");
            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieTIK();
            if(Serie_.getType().compareTo("TIK")!=0){
                Assertions.fail();
                return;
            }
            
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "TIK found");
            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieCOT();
            if(Serie_.getType().compareTo("COT")!=0){
                Assertions.fail();
                return;
            }
            
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "COT found");
            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieEMP();
            if(Serie_.getType().compareTo("EMP")!=0){
                Assertions.fail();
                return;
            }
            
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "EMP found");
            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSeriePROV();
            if(Serie_.getType().compareTo("PROV")!=0){
                Assertions.fail();
                return;
            }
            
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "PROV found");
            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieREM();
            if(Serie_.getType().compareTo("REM")!=0){
                Assertions.fail();
                return;
            }
            
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "REM found");
            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieCOMP();
            if(Serie_.getType().compareTo("COMP")!=0){
                Assertions.fail();
                return;
            }
            
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "COMP found");
            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieORDC();
            if(Serie_.getType().compareTo("ORDC")!=0){
                Assertions.fail();
                return;
            }
            
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "ORDC found");
            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieCXC();
            if(Serie_.getType().compareTo("CXC")!=0){
                Assertions.fail();
                return;
            }
            
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "CXC found");
            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSeriePEDIDOS();
            if(Serie_.getType().compareTo("PEDIDOS")!=0){
                Assertions.fail();
                return;
            }
            
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "PEDIDOS found");
            
            Assertions.assertTrue(true);
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }
    
    @Test
    @Order(4)
    public void addSerieTypeTest() {
                
        try{
            
            Serie Serie = new Serie();
            Serie.setSerie("TEST");
            Serie.setDescription("Description test");            
            Serie.setConsecutive(0);
            Serie.setEstation("ESTAC1");
            Serie.setSucursal("SUC1");
            Serie.setCashNumber("CAJ1");            
            RepositoryManager.getInstance().getSerieRepository().addSerieTypeCOMP(Serie);            
            Serie Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieCOMP();
            if(Serie_==null){
                Assertions.fail();
                return;
            }
            RepositoryManager.getInstance().getSerieRepository().removeSerie(Serie_.getId());
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "PREV added and removed");
            
            RepositoryManager.getInstance().getSerieRepository().addSerieTypeNOTC(Serie);            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieNOTC();
            if(Serie_==null){
                Assertions.fail();
                return;
            }
            RepositoryManager.getInstance().getSerieRepository().removeSerie(Serie_.getId());
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "NOTC added and removed");
            
            RepositoryManager.getInstance().getSerieRepository().addSerieTypeNOTP(Serie);            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieNOTP();
            if(Serie_==null){
                Assertions.fail();
                return;
            }
            RepositoryManager.getInstance().getSerieRepository().removeSerie(Serie_.getId());
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "NOTP added and removed");
            
            RepositoryManager.getInstance().getSerieRepository().addSerieTypeFAC(Serie);            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieFAC();
            if(Serie_==null){
                Assertions.fail();
                return;
            }
            RepositoryManager.getInstance().getSerieRepository().removeSerie(Serie_.getId());
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "FAC added and removed");
            
            RepositoryManager.getInstance().getSerieRepository().addSerieTypeTIK(Serie);            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieTIK();
            if(Serie_==null){
                Assertions.fail();
                return;
            }
            RepositoryManager.getInstance().getSerieRepository().removeSerie(Serie_.getId());
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "TIK added and removed");
            
            RepositoryManager.getInstance().getSerieRepository().addSerieTypeCOT(Serie);            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieCOT();
            if(Serie_==null){
                Assertions.fail();
                return;
            }
            RepositoryManager.getInstance().getSerieRepository().removeSerie(Serie_.getId());
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "COT added and removed");
            
            RepositoryManager.getInstance().getSerieRepository().addSerieTypeEMP(Serie);            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieEMP();
            if(Serie_==null){
                Assertions.fail();
                return;
            }
            RepositoryManager.getInstance().getSerieRepository().removeSerie(Serie_.getId());
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "EMP added and removed");
            
            RepositoryManager.getInstance().getSerieRepository().addSerieTypePROV(Serie);            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSeriePROV();
            if(Serie_==null){
                Assertions.fail();
                return;
            }
            RepositoryManager.getInstance().getSerieRepository().removeSerie(Serie_.getId());
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "PROV added and removed");
            
            RepositoryManager.getInstance().getSerieRepository().addSerieTypeREM(Serie);            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieREM();
            if(Serie_==null){
                Assertions.fail();
                return;
            }
            RepositoryManager.getInstance().getSerieRepository().removeSerie(Serie_.getId());
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "REM added and removed");
            
            RepositoryManager.getInstance().getSerieRepository().addSerieTypeCOMP(Serie);            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieCOMP();
            if(Serie_==null){
                Assertions.fail();
                return;
            }
            RepositoryManager.getInstance().getSerieRepository().removeSerie(Serie_.getId());
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "COMP added and removed");
            
            RepositoryManager.getInstance().getSerieRepository().addSerieTypeORDC(Serie);            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieORDC();
            if(Serie_==null){
                Assertions.fail();
                return;
            }
            RepositoryManager.getInstance().getSerieRepository().removeSerie(Serie_.getId());
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "ORDC added and removed");
            
            RepositoryManager.getInstance().getSerieRepository().addSerieTypeCXC(Serie);            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSerieCXC();
            if(Serie_==null){
                Assertions.fail();
                return;
            }
            RepositoryManager.getInstance().getSerieRepository().removeSerie(Serie_.getId());
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "CXC added and removed");
            
            RepositoryManager.getInstance().getSerieRepository().addSerieTypePEDIDOS(Serie);            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSeriePEDIDOS();
            if(Serie_==null){
                Assertions.fail();
                return;
            }
            RepositoryManager.getInstance().getSerieRepository().removeSerie(Serie_.getId());
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "PEDIDOS added and removed");
            
            Assertions.assertTrue(true);
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }
    
    @Test
    @Order(4)
    public void addSerieTypeTest() {
                
        try{
            
            Serie Serie = new Serie();
            Serie.setSerie("TEST");
            Serie.setDescription("Description test");            
            Serie.setConsecutive(0);
            Serie.setEstation("ESTAC1");
            Serie.setSucursal("SUC1");
            Serie.setCashNumber("CAJ1");            
            RepositoryManager.getInstance().getSerieRepository().addSerieTypePREV(Serie);            
            Serie Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSeriePREV();
            if(Serie_==null){
                LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "getFirstSeriePREV() returned null");
                Assertions.fail();
                return;
            }
            
            RepositoryManager.getInstance().getSerieRepository().updateSerie(Serie);
            
            Serie_ = RepositoryManager.getInstance().getSerieRepository().getFirstSeriePREV();
            
            if(Serie_.getConsecutive()!=1){
                LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "Serie_.getConsecutive()!=1");
                Assertions.fail();
                return;
            }
            
            RepositoryManager.getInstance().getSerieRepository().removeSerie(Serie_.getId());
            LoggerUtility.getSingleton().logInfo(SerieJUnitTest.class, "Serie removed");
            
            Assertions.assertTrue(true);
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }*/
}
