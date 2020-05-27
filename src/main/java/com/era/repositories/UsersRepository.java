package com.era.repositories;

import com.era.models.User;
import com.era.repositories.utils.HibernateUtil;
import com.era.utilities.UtilitiesFactory;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

public class UsersRepository extends Repository {

   public UsersRepository() {
        super(User.class);
    }
   
    final public void save(final User User) throws Exception {
        
        //Get the current default printer
        final String defaultPrinter = UtilitiesFactory.getSingleton().getPrintersUtility().getDefaultPrinter();
        User.setTicketPrinter(defaultPrinter);
        User.setInvoicePrinter(defaultPrinter);
        
        //Encrypt the user pasword
        final String passwordEncrypted = UtilitiesFactory.getSingleton().getSecurityUtil().encryptString(User.getPassword().trim());
        User.setPassword(passwordEncrypted);
        
        //Save the user
        super.save(User);
    }
    
    final public void update(final User User) throws Exception {
        
        //Encrypt the user pasword
        final String passwordEncrypted = UtilitiesFactory.getSingleton().getSecurityUtil().encryptString(User.getPassword().trim());
        User.setPassword(passwordEncrypted);
        
        //Save the user
        super.update(User);                
    }
    
    final public boolean isSalesPointUser(final String code) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM User where code = :code";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("code", code);
        User User = query.list().size() > 0 ? (User)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return User!=null?User.isUserOfsalesOfPoint():false;
    }
    
    final public boolean userExists(final String code) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM User where code = :code";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("code", code);
        User User = query.list().size() > 0 ? (User)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return User!=null;
    }
    
    final public String getDecryptedUserPassword(final String code) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM User where code = :code";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("code", code);
        User User = query.list().size() > 0 ? (User)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
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
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM User where code = :code";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("code", code);
        User User = query.list().size() > 0 ? (User)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        if(User!=null){
            RepositoryFactory.getInstance().getLogsRepository().userLoggedToSystem();
        }
    }
    
    final public void userDeloggedToSystem(final String code) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM User where code = :code";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("code", code);
        User User = query.list().size() > 0 ? (User)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        if(User!=null){
            RepositoryFactory.getInstance().getLogsRepository().userLoggedOutToSystem();
        }
    }
    
    final public List<User> getAllVends() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM User where vend = true";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);        
        List<User> users = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return users;
    }
    
    final public List<User> getAllCashAdmin() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM User where admcaj = true";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);        
        List<User> users = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        //Return the result model
        return users;
    }
    
    final public List<User> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("nom");
        likes.add("pass");
        likes.add("falt");
        likes.add("fmod");
        
        final List<User> users = (List<User>) this.getAllLike(likes, search);
        
        return users;
    }
}