package com.era.repositories;

import com.era.models.Log;
import com.era.utilities.UtilitiesFactory;
import java.util.ArrayList;
import java.util.List;

public class LogsRepository extends Repository {

   public LogsRepository() {
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
    
    //This method do not save as normal others repositories methods
    final public void save(Log Log) throws Exception {
        this.saveInNewConnection(Log);
        
    }
    
    final public Log userLoggedToSystem() throws Exception {
        
        final String user = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getCode();
        
        Log Log = new Log();
        Log.setCod(user);
        Log.setType("USER");
        Log.setAccio("LOGGED");
        Log.setDescrip("USER LOGGED TO SYSTEM");        
        
        this.save(Log);
        
        return Log;
    }
    
    final public Log userLoggedOutToSystem() throws Exception {
        
        final String user = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getCode();
        
        Log Log = new Log();
        Log.setCod(user);
        Log.setType("USER");
        Log.setAccio("LOGGEDOUT");
        Log.setDescrip("USER LOGGED TO SYSTEM");        
        
        this.save(Log);
        
        return Log;
    }
    
    @Override
    final public List<Log> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<Log> items = (List<Log>) this.getAllLike(likes, search);
        
        return items;
    }
}