package com.era.repositories;

import com.era.models.User;
import com.era.repositories.utils.HibernateUtil;
import com.era.utilities.UtilitiesFactory;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class UsersRepository extends Repository {

    public UsersRepository() {
        super(User.class);
    }
    
    @Override
    public List<?> getAllBySearchFilter(final String search) throws Exception {
        
        //Open database
        openDatabase();       
        
        final Session Session = HibernateUtil.getSingleton().getSession();
        
        String hql = "FROM User WHERE code LIKE:code OR email LIKE:email OR name LIKE:name";
        Query query = Session.createQuery(hql);
        query.setParameter("code", "%" + search + "%");
        query.setParameter("email", "%" + search + "%");
        query.setParameter("name", "%" + search + "%");
        List<?> records = query.list();
        
        //Close database
        closeDatabase();
        
        //Return the result model
        return records;
    }
    
    final public boolean isValidAdminUser(final String user, final String password) throws Exception {
    
        //Get if the user exists
        final boolean userExists = RepositoryFactory.getInstance().getUsersRepository().userExists(user);
            
        //If the user does not exists stop
        if(!userExists){
            return false;
        }

        //Get decrypted password
        final String decryptedPassword = RepositoryFactory.getInstance().getUsersRepository().getDecryptedUserPassword(user);

        //Passwords match ?
        if(password.compareTo(decryptedPassword)!=0){
            return false;
        }
        
        //All is fine
        return true;
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
    
    final public void updateUser(final User User) throws Exception {
        
        //Save the user
        super.update(User);                
    }
    
    final public void updatePrinters(   final String code, 
                                        final String ticketPrinter, 
                                        final String invoicePrinter,
                                        final boolean m52,
                                        final boolean cort) throws Exception {
               
        final User User = (User)this.getByCode(code);
        User.setInvoicePrinter(invoicePrinter);
        User.setTicketPrinter(ticketPrinter);
        User.setM52(m52);
        User.setCort(cort);
        final String decryptedPassword = this.getDecryptedUserPassword(User.getCode());        
        User.setPassword(decryptedPassword);
        this.update(User);
    }
    
    final public boolean isSalesPointUser(final String code) throws Exception {
        
        //Open database
        openDatabase();
        
        String hql = "FROM User where code = :code";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("code", code);
        User User = query.list().size() > 0 ? (User)query.list().get(0):null;
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return User!=null?User.isUserOfsalesOfPoint():false;
    }
    
    final public boolean userExists(final String code) throws Exception {
        
        //Open database
        openDatabase();
        
        String hql = "FROM User where code = :code";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("code", code);
        User User = query.list().size() > 0 ? (User)query.list().get(0):null;
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return User!=null;
    }
    
    final public String getDecryptedUserPassword(final String code) throws Exception {
        
        //Open database
        openDatabase();
        
        String hql = "FROM User where code = :code";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("code", code);
        User User = query.list().size() > 0 ? (User)query.list().get(0):null;
        
        //Close database        
        closeDatabase();
        
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
        openDatabase();
        
        String hql = "FROM User where code = :code";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("code", code);
        User User = query.list().size() > 0 ? (User)query.list().get(0):null;
        
        //Close database        
        closeDatabase();
        
        if(User!=null){
            RepositoryFactory.getInstance().getLogsRepository().userLoggedToSystem();
        }
    }
    
    final public void userDeloggedToSystem(final String code) throws Exception {
        
        //Open database
        openDatabase();
        
        String hql = "FROM User where code = :code";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("code", code);
        User User = query.list().size() > 0 ? (User)query.list().get(0):null;
        
        //Close database        
        closeDatabase();
        
        if(User!=null){
            RepositoryFactory.getInstance().getLogsRepository().userLoggedOutToSystem();
        }
    }
    
    final public List<User> getAllVends() throws Exception {
        
        //Open database
        openDatabase();
        
        String hql = "FROM User where vend = true";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);        
        List<User> users = query.list();
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return users;
    }
    
    final public List<User> getAllCashAdmin() throws Exception {
        
        //Open database
        openDatabase();
        
        String hql = "FROM User where admcaj = true";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);        
        List<User> users = query.list();
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return users;
    }
    
    @Override
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