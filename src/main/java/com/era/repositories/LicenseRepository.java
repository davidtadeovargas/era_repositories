/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.License;
import com.era.repositories.utils.HibernateUtil;
import com.era.logger.LoggerUtility;
import com.era.utilities.UtilitiesFactory;
import com.era.utilities.exceptions.EncryptionException;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class LicenseRepository extends Repository {
    
    protected LicenseRepository(){
        super(License.class);
    }
    
    final public License addLicense(License License) throws Exception{
                
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: Adding license");
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: user: " + License.getUser());
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: password: " + License.getPassword());
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: serverDate: " + License.getServerDate());
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: users: " + License.getUsers());
        
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

        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: License added");                
        
        return License;
    }
    
    
    final public License getLicense() throws Exception {
                        
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: Getting license");
        
        //Open database
        this.openSession();
        
        Query query = session.createQuery("from License");
        License License = query.list().size() > 0 ? (License) query.list().get(0):null;
        if(License!=null){
            
            //Decrypt variables
            try{

                //Decrypt variables
                License.setUser(UtilitiesFactory.getSingleton().getSecurityUtil().decryptString(License.getUser()));
                License.setPassword(UtilitiesFactory.getSingleton().getSecurityUtil().decryptString(License.getPassword()));
                License.setServerDate(UtilitiesFactory.getSingleton().getSecurityUtil().decryptString(License.getServerDate()));

            }catch(Exception e){
                LoggerUtility.getSingleton().logError(LicenseRepository.class, e);
                throw new EncryptionException();
            }
        }            
        
        //Close database       
        HibernateUtil.getSingleton().shutdown();
        
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: Returning license: " + License);
        
        //Return the response model
        return License;
    }
    
    
    final public String getChannel() throws Exception {
                        
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: Getting channel");
        
        final License License = this.getLicense();
        
        final String channel = License.getChannel();
        
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: Returning channel: " + channel);
        
        return channel;
    }    
    
    final public String updateChannel(final String channel) throws Exception {
                        
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: updading channel " + channel);
                
        License License = this.getLicense();
        if(License!=null){
            
            License.setChannel(channel);

            //Save or update the licence            
            update(License);
        }
        
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: Channel updated: " + channel);
        
        return channel;
    }
        
    final public boolean existsLicense() throws Exception {
                        
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: Getting if license exists");
        
        //Get the license
        final License License = getLicense();
        
        boolean response = true;        
        if(License==null){
            response = false;
        }
        
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: Response " + response);
        
        //Return the response
        return response;
    }    
        
    final public License deleteLicense() throws Exception {

        //Get the license
        final License License = getLicense();
        
        //Open database
        this.openSession();
        
        //Delete the license
        if(License!=null){
            session.delete(License);
        }            
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        return License;
    }
}
