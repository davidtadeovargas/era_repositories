/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.PushNotification;
import com.era.repositories.utils.HibernateUtil;
import com.era.logger.LoggerUtility;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class PushNotificationsRepository extends Repository {
    
    protected PushNotificationsRepository(){
        super(PushNotification.class);
    }
    
    final public PushNotification newNotification(  final String message, 
                                                    final String urlBanner, 
                                                    final String bannerAction) throws Exception{
        
        LoggerUtility.getSingleton().logInfo(PushNotificationsRepository.class, "Hibernate: Creating new notification");
        
        LoggerUtility.getSingleton().logInfo(PushNotificationsRepository.class, "Hibernate: message: " + message);
        LoggerUtility.getSingleton().logInfo(PushNotificationsRepository.class, "Hibernate: urlBanner: " + urlBanner);
        LoggerUtility.getSingleton().logInfo(PushNotificationsRepository.class, "Hibernate: bannerAction: " + bannerAction);
        
        //Create the model
        final PushNotification PushNotification = new PushNotification();
        PushNotification.setMessage(message);
        PushNotification.setUrlBanner(urlBanner);
        PushNotification.setBannerAction(bannerAction);
        
        //Save the model
        this.save(PushNotification);
        
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: Saved");
        
        return PushNotification;
    }
    
    final public List<PushNotification> getTodayNotifications() throws Exception{
        
        LoggerUtility.getSingleton().logInfo(PushNotificationsRepository.class, "Hibernate: Getting today notifications");
        
        //Open database
        this.openSession();
        
        Query query = session.createQuery("from PushNotification where date(created) = date(now())");
        List<PushNotification> PushNotifications = query.list();
        
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: push notifications: " + PushNotifications);
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: Returning push notifications");
        
        return PushNotifications;
    }
    
    final public List<PushNotification> getMonthNotifications() throws Exception{
        
        LoggerUtility.getSingleton().logInfo(PushNotificationsRepository.class, "Hibernate: Getting month notifications");
        
        //Open database
        this.openSession();
        
        Query query = session.createQuery("from PushNotification where MONTH(date(created)) = MONTH(date(now()))");
        List<PushNotification> PushNotifications = query.list();
        
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: push notifications: " + PushNotifications);
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        LoggerUtility.getSingleton().logInfo(LicenseRepository.class, "Hibernate: Returning push notifications");
        
        return PushNotifications;
    }
}
