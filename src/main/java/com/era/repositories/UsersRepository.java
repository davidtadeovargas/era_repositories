/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.repositories.utils.HibernateUtil;
import com.era.models.User;
import com.era.utilities.UtilitiesFactory;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 *
 * @author PC
 */
public class UsersRepository extends Repository {

    protected UsersRepository(){
        super(User.class);
    }        
    
    final public User getUsrByCode(final String code) throws Exception {
        
        //Open database
        this.openSession();
        
        String hql = "FROM User where estac = :code";
        Query query = session.createQuery(hql);
        query.setParameter("code", code);
        User User = query.list().size() > 0 ? (User)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return User;
    }
    
    final public boolean isSalesPointUser(final String code) throws Exception {
        
        //Open database
        this.openSession();
        
        String hql = "FROM User where estac = :code";
        Query query = session.createQuery(hql);
        query.setParameter("code", code);
        User User = query.list().size() > 0 ? (User)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return User!=null?User.isUserOfsalesOfPoint():false;
    }
    
    final public boolean userExists(final String code) throws Exception {
        
        //Open database
        this.openSession();
        
        String hql = "FROM User where estac = :code";
        Query query = session.createQuery(hql);
        query.setParameter("code", code);
        User User = query.list().size() > 0 ? (User)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return User!=null;
    }
    
    final public String getDecryptedUserPassword(final String code) throws Exception {
        
        //Open database
        this.openSession();
        
        String hql = "FROM User where estac = :code";
        Query query = session.createQuery(hql);
        query.setParameter("code", code);
        User User = query.list().size() > 0 ? (User)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        if(User!=null){
            
            //Decrypt
            final String passwordDecrypted = UtilitiesFactory.getSingleton().getSecurityUtil().decryptString(User.getPassword());

            //Return the result model
            return passwordDecrypted;
        }
        else{
            return null;
        }
    }
    
    
    final public void userLoggedToSystem(final String code) throws Exception {
        
        //Open database
        this.openSession();
        
        String hql = "FROM User where estac = :code";
        Query query = session.createQuery(hql);
        query.setParameter("code", code);
        User User = query.list().size() > 0 ? (User)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        if(User!=null){
            RepositoryFactory.getInstance().getLogRepository().userLoggedToSystem();
        }
    }
    
    final public void userDeloggedToSystem(final String code) throws Exception {
        
        //Open database
        this.openSession();
        
        String hql = "FROM User where estac = :code";
        Query query = session.createQuery(hql);
        query.setParameter("code", code);
        User User = query.list().size() > 0 ? (User)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        if(User!=null){
            RepositoryFactory.getInstance().getLogRepository().userLoggedOutToSystem();
        }
    }
    
    final public List<User> getAllVends() throws Exception {
        
        //Open database
        this.openSession();
        
        String hql = "FROM User where vend = true";
        Query query = session.createQuery(hql);        
        List<User> users = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return users;
    }
    
    final public List<User> getAllCashAdmin() throws Exception {
        
        //Open database
        this.openSession();
        
        String hql = "FROM User where admcaj = true";
        Query query = session.createQuery(hql);        
        List<User> users = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return users;
    }
    
    final public void deleteByEstac(final String estac) throws Exception{
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        //Save
        final SQLQuery SQLQuery = session.createSQLQuery("DELETE FROM User WHERE estac = :estac");
        SQLQuery.setParameter("estac", estac);
        SQLQuery.executeUpdate();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
    }
    
    final public List<User> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("estac");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<User> users = (List<User>) this.getAllLike(likes, search);
        
        return users;
    }   
}