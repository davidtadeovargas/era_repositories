package com.era.repositories;

import com.era.models.ServerSession;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;

public class ServerSessionsRepository extends Repository {

   public ServerSessionsRepository() {
        super(ServerSession.class);
    }
   
   final public ServerSession addServerSession(ServerSession ServerSession) throws Exception{
                
        if(ServerSession.getId()>0){
            update(ServerSession);
        }
        else{
            save(ServerSession);
        }        

        return ServerSession;
    }
    
    final public ServerSession getServerSession() throws Exception {
                        
        //Open database        
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        Query query = HibernateUtil.getSingleton().getSession().createQuery("from ServerSession");
        ServerSession ServerSession = query.list().size() > 0 ? (ServerSession) query.list().get(0):null;
        
        //Close database                
        HibernateUtil.getSingleton().closeSession();
        
        //Return the response model
        return ServerSession;
    }
}