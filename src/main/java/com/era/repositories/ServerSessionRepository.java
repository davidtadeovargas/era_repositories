/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.ServerSession;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class ServerSessionRepository extends Repository {

    protected ServerSessionRepository(){
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
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        
        Query query = session.createQuery("from ServerSession");
        ServerSession ServerSession = query.list().size() > 0 ? (ServerSession) query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the response model
        return ServerSession;
    }
}
