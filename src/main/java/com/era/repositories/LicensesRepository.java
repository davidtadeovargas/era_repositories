package com.era.repositories;

import com.era.logger.LoggerUtility;
import com.era.models.License;
import com.era.repositories.utils.HibernateUtil;
import com.era.utilities.UtilitiesFactory;
import com.era.utilities.exceptions.EncryptionException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

public class LicensesRepository extends Repository {

   public LicensesRepository() {
        super(License.class);
    }
   
   final public License addLicense(License License) throws Exception{
                
        LoggerUtility.getSingleton().logInfo(LicensesRepository.class, "Hibernate: Adding license");
        LoggerUtility.getSingleton().logInfo(LicensesRepository.class, "Hibernate: user: " + License.getUser());
        LoggerUtility.getSingleton().logInfo(LicensesRepository.class, "Hibernate: password: " + License.getPassword());
        LoggerUtility.getSingleton().logInfo(LicensesRepository.class, "Hibernate: serverDate: " + License.getServerDate());
        LoggerUtility.getSingleton().logInfo(LicensesRepository.class, "Hibernate: users: " + License.getUsers());
        
        //Encript variables
        String userEncrypted;
        String passwordEncrypted;
        String serverDateEncrypted;        
        try{
                        
            userEncrypted = UtilitiesFactory.getSingleton().getSecurityUtil().encryptString(License.getUser());
            passwordEncrypted = UtilitiesFactory.getSingleton().getSecurityUtil().encryptString(License.getPassword());
            serverDateEncrypted = UtilitiesFactory.getSingleton().getSecurityUtil().encryptString(License.getServerDate());            

        }catch(Exception e){
            throw new EncryptionException();
        }
        
        //Create license
        License.setUser(userEncrypted);
        License.setPassword(passwordEncrypted);
        License.setServerDate(serverDateEncrypted);        
        
        //Save the licence
        if(License.getId()>0){
            this.update(License);
        }
        else{
            this.save(License);
        }        

        LoggerUtility.getSingleton().logInfo(LicensesRepository.class, "Hibernate: License added");                
        
        return License;
    }
    
    
    final public License getLicense() throws Exception {
                        
        LoggerUtility.getSingleton().logInfo(LicensesRepository.class, "Hibernate: Getting license");
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        Query query = HibernateUtil.getSingleton().getSession().createQuery("from License");
        License License = query.list().size() > 0 ? (License) query.list().get(0):null;
        if(License!=null){
            
            //Decrypt variables
            try{

                //Decrypt variables
                License.setUser(UtilitiesFactory.getSingleton().getSecurityUtil().decryptString(License.getUser()));
                License.setPassword(UtilitiesFactory.getSingleton().getSecurityUtil().decryptString(License.getPassword()));
                License.setServerDate(UtilitiesFactory.getSingleton().getSecurityUtil().decryptString(License.getServerDate()));

            }catch(Exception e){
                LoggerUtility.getSingleton().logError(LicensesRepository.class, e);
                throw new EncryptionException();
            }
        }            
        
        //Close database       
        HibernateUtil.getSingleton().closeSession();
        
        LoggerUtility.getSingleton().logInfo(LicensesRepository.class, "Hibernate: Returning license: " + License);
        
        //Return the response model
        return License;
    }
    
    
    final public String getChannel() throws Exception {
                        
        LoggerUtility.getSingleton().logInfo(LicensesRepository.class, "Hibernate: Getting channel");
        
        final License License = this.getLicense();
        
        final String channel = License.getChannel();
        
        LoggerUtility.getSingleton().logInfo(LicensesRepository.class, "Hibernate: Returning channel: " + channel);
        
        return channel;
    }    
    
    final public String updateChannel(final String channel) throws Exception {
                        
        LoggerUtility.getSingleton().logInfo(LicensesRepository.class, "Hibernate: updading channel " + channel);
                
        License License = this.getLicense();
        if(License!=null){
            
            License.setChannel(channel);

            //Save or update the licence            
            update(License);
        }
        
        LoggerUtility.getSingleton().logInfo(LicensesRepository.class, "Hibernate: Channel updated: " + channel);
        
        return channel;
    }
        
    final public boolean existsLicense() throws Exception {
                        
        LoggerUtility.getSingleton().logInfo(LicensesRepository.class, "Hibernate: Getting if license exists");
        
        //Get the license
        final License License = getLicense();
        
        boolean response = true;        
        if(License==null){
            response = false;
        }
        
        LoggerUtility.getSingleton().logInfo(LicensesRepository.class, "Hibernate: Response " + response);
        
        //Return the response
        return response;
    }    
        
    final public License deleteLicense() throws Exception {

        //Get the license
        final License License = getLicense();
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        //Delete the license
        if(License!=null){
            HibernateUtil.getSingleton().getSession().delete(License);
        }            
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        return License;
    }
    
    @Override
    final public List<License> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<License> items = (List<License>) this.getAllLike(likes, search);
        
        return items;
    }
}