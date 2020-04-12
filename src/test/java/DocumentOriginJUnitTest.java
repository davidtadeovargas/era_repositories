
import com.era.logger.LoggerUtility;
import com.era.models.DocumentOrigin;
import com.era.repositories.RepositoryFactory;
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
public class DocumentOriginJUnitTest  {
    
    @Test
    @Order(1)
    public final void getLicenseTest(){
        
        try{
            
            DocumentOrigin DocumentOrigin = RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentOriginPREV();
            if(DocumentOrigin.getType().compareTo("PREV")!=0){
                Assertions.fail();
            }
            LoggerUtility.getSingleton().logInfo(DocumentOriginJUnitTest.class, "Passed PREV");
            
            DocumentOrigin = RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentOriginNOTC();
            if(DocumentOrigin.getType().compareTo("NOTC")!=0){
                Assertions.fail();
            }
            LoggerUtility.getSingleton().logInfo(DocumentOriginJUnitTest.class, "Passed NOTP");
            
            DocumentOrigin = RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentOriginNOTP();
            if(DocumentOrigin.getType().compareTo("NOTP")!=0){
                Assertions.fail();
            }
            LoggerUtility.getSingleton().logInfo(DocumentOriginJUnitTest.class, "Passed NOTP");
            
            DocumentOrigin = RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentOriginFAC();
            if(DocumentOrigin.getType().compareTo("FAC")!=0){
                Assertions.fail();
            }
            LoggerUtility.getSingleton().logInfo(DocumentOriginJUnitTest.class, "Passed FAC");
            
            DocumentOrigin = RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentOriginTIK();
            if(DocumentOrigin.getType().compareTo("TIK")!=0){
                Assertions.fail();
            }
            LoggerUtility.getSingleton().logInfo(DocumentOriginJUnitTest.class, "Passed TIK");
            
            DocumentOrigin = RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentOriginCOT();
            if(DocumentOrigin.getType().compareTo("COT")!=0){
                Assertions.fail();
            }
            LoggerUtility.getSingleton().logInfo(DocumentOriginJUnitTest.class, "Passed COT");
            
            DocumentOrigin = RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentOriginEMP();
            if(DocumentOrigin.getType().compareTo("EMP")!=0){
                Assertions.fail();
            }
            LoggerUtility.getSingleton().logInfo(DocumentOriginJUnitTest.class, "Passed EMP");
            
            DocumentOrigin = RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentOriginPROV();
            if(DocumentOrigin.getType().compareTo("PROV")!=0){
                Assertions.fail();
            }
            LoggerUtility.getSingleton().logInfo(DocumentOriginJUnitTest.class, "Passed PROV");
            
            DocumentOrigin = RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentOriginREM();
            if(DocumentOrigin.getType().compareTo("REM")!=0){
                Assertions.fail();
            }
            LoggerUtility.getSingleton().logInfo(DocumentOriginJUnitTest.class, "Passed REM");
            
            DocumentOrigin = RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentOriginCOMP();
            if(DocumentOrigin.getType().compareTo("COMP")!=0){
                Assertions.fail();
            }
            LoggerUtility.getSingleton().logInfo(DocumentOriginJUnitTest.class, "Passed COMP");
            
            DocumentOrigin = RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentOriginORDC();
            if(DocumentOrigin.getType().compareTo("ORDC")!=0){
                Assertions.fail();
            }
            LoggerUtility.getSingleton().logInfo(DocumentOriginJUnitTest.class, "Passed ORDC");
            
            DocumentOrigin = RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentOriginPAG();
            if(DocumentOrigin.getType().compareTo("PAG")!=0){
                Assertions.fail();
            }
            LoggerUtility.getSingleton().logInfo(DocumentOriginJUnitTest.class, "Passed PAG");
            
            DocumentOrigin = RepositoryFactory.getInstance().getDocumentOriginRepository().getDocumentOriginPED();
            if(DocumentOrigin.getType().compareTo("PED")!=0){
                Assertions.fail();
            }
            LoggerUtility.getSingleton().logInfo(DocumentOriginJUnitTest.class, "Passed PED");
            
            Assertions.assertTrue(true);
        
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }        
    }
    
    @Test
    @Order(2)
    public void getAllTest() {
                
        try{
            
            List<DocumentOrigin> documents = (List<DocumentOrigin>) RepositoryFactory.getInstance().getDocumentOriginRepository().getAll();
            
            if(documents.size()==13){
                Assertions.assertTrue(true);
            }
            else{
                Assertions.fail();
            }
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }
    
    @Test
    @Order(3)
    public void getDocumentByNameTest() {
                
        try{
            
            DocumentOrigin DocumentOrigin = (DocumentOrigin) RepositoryFactory.getInstance().getDocumentOriginRepository().getByName("REMISIONES");
            
            if(DocumentOrigin.getName().compareTo("REMISIONES")==0){
                Assertions.assertTrue(true);
            }
            else{
                Assertions.fail();
            }
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(CompanyJUnitTest.class, e);
            
            Assertions.fail();
        }            
    }
}
