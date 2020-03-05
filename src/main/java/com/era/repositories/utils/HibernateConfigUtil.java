/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories.utils;

import com.era.repositories.models.HibernateConfigModel;
import java.io.File;
import com.era.logger.LoggerUtility;
import java.util.StringTokenizer;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author PC
 */
public class HibernateConfigUtil {
    
    private static HibernateConfigUtil HibernateConfigUtil;
    
    
    
    private HibernateConfigUtil(){
    }
    
    final public static HibernateConfigUtil getInstance(){
        if(HibernateConfigUtil==null){
            HibernateConfigUtil = new HibernateConfigUtil();
        }
        return HibernateConfigUtil;
    }
    
    final public HibernateConfigModel getHibernateConfigFile(){
        
        LoggerUtility.getSingleton().logInfo(HibernateConfigUtil.class, " getting hibernate config file");
        
        final HibernateConfigModel HibernateConfigModel = new HibernateConfigModel();        
        HibernateConfigModel.setUser(this.getUserFromJDBCUrl());
        HibernateConfigModel.setPassword(this.getPasswordFromJDBCUrl());
        HibernateConfigModel.setDatabase(this.getDatabaseFromJDBCUrl());
        HibernateConfigModel.setPort(this.getPortFromJDBCUrl());
        HibernateConfigModel.setInstance(this.getInstanceFromJDBCUrl());
        
        LoggerUtility.getSingleton().logInfo(HibernateConfigUtil.class, " returning " + HibernateConfigModel);
        
        return HibernateConfigModel;
    }
    
    final private Configuration getConfigurationObject(){
        
        File config = new File("hibernate.cfg.xml");
        Configuration configuration = new Configuration().configure();
        return configuration;
    }
    
    final private String getInstanceFromJDBCUrl(){
        
        Configuration configuration = getConfigurationObject();
        final String url = configuration.getProperty("hibernate.connection.url");
        StringTokenizer StringTokenizer = new StringTokenizer(url,"//"); //localhost:3306/dbempresas
        String tokenized = StringTokenizer.nextToken();
        tokenized = StringTokenizer.nextToken();
        StringTokenizer = new StringTokenizer(tokenized,":"); //localhost 3306
        tokenized = StringTokenizer.nextToken();
        final String instance = tokenized;
        
        return instance;
    }
    
    final private String getUserFromJDBCUrl(){
        
        Configuration configuration = getConfigurationObject();
        final String username = configuration.getProperty("hibernate.connection.username");        
        return username;
    }
    
    final private String getPasswordFromJDBCUrl(){
        
        Configuration configuration = getConfigurationObject();
        final String password = configuration.getProperty("hibernate.connection.password");        
        return password;
    }
    
    final private int getPortFromJDBCUrl(){
        
        Configuration configuration = getConfigurationObject();
        final String url = configuration.getProperty("hibernate.connection.url");
        StringTokenizer StringTokenizer = new StringTokenizer(url,"//"); //localhost:3306/dbempresas
        String tokenized = StringTokenizer.nextToken();
        tokenized = StringTokenizer.nextToken();
        StringTokenizer = new StringTokenizer(tokenized,":"); //localhost 3306
        StringTokenizer.nextToken();
        tokenized = StringTokenizer.nextToken();
        final String port = tokenized;
        
        return Integer.valueOf(port);
    }
    
    final private String getDatabaseFromJDBCUrl(){
        
        Configuration configuration = getConfigurationObject();
        final String url = configuration.getProperty("hibernate.connection.url");
        StringTokenizer StringTokenizer = new StringTokenizer(url,"//"); //localhost:3306/dbempresas
        String tokenized = StringTokenizer.nextToken();
        tokenized = StringTokenizer.nextToken();
        tokenized = StringTokenizer.nextToken();
        StringTokenizer = new StringTokenizer(tokenized,"/");
        tokenized = StringTokenizer.nextToken();
        final String database = tokenized;
        
        return database;
    }
            
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
