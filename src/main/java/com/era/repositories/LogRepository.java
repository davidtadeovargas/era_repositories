/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Log;

/**
 *
 * @author PC
 */
public class LogRepository extends Repository {
    
    protected LogRepository(){
        super(Log.class);
    }
    
    final public Log addCustomerLog(final String companyCode) throws Exception {
        
        Log Log = new Log();
        Log.setCod(companyCode);
        Log.setType("CUSTOMER");
        Log.setAccio("ADD");
        Log.setDescrip("USER CREATED");        
        
        this.save(Log);
        
        return Log;
    }
    
    final public Log updateCustomerLog(final String companyCode) throws Exception {
        
        Log Log = new Log();
        Log.setCod(companyCode);
        Log.setType("CUSTOMER");
        Log.setAccio("UPDATE");
        Log.setDescrip("USER CREATED");        
        
        this.save(Log);
        
        return Log;
    }
    
    final public Log userLoggedToSystem() throws Exception {
        
        final String user = RepositoryManager.getInstance().getUsersRepository().getUser();
        
        Log Log = new Log();
        Log.setCod(user);
        Log.setType("USER");
        Log.setAccio("LOGGED");
        Log.setDescrip("USER LOGGED TO SYSTEM");        
        
        this.save(Log);
        
        return Log;
    }
    
    final public Log userLoggedOutToSystem() throws Exception {
        
        final String user = RepositoryManager.getInstance().getUsersRepository().getUser();
        
        Log Log = new Log();
        Log.setCod(user);
        Log.setType("USER");
        Log.setAccio("LOGGEDOUT");
        Log.setDescrip("USER LOGGED TO SYSTEM");        
        
        this.save(Log);
        
        return Log;
    }
}