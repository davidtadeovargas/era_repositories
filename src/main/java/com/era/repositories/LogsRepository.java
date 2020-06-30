package com.era.repositories;

import com.era.models.Log;
import com.era.repositories.utils.HibernateUtil;
import com.era.utilities.UtilitiesFactory;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

public class LogsRepository extends Repository {

   public LogsRepository() {
        super(Log.class);
    }
   
   final public Log addCustomerLog(final String companyCode) throws Exception {
        
        Log Log = new Log();
        Log.setCode(companyCode);
        Log.setType("CUSTOMER");
        Log.setAccio("save");
        Log.setDescrip("USER CREATED");
        
        this.save(Log);
        
        return Log;
    }
    
    final public List<Log> getAllAccioSave() throws Exception {
        return getAllByAction("save");        
    }
    final public List<Log> getAllAccioUpdate() throws Exception {
        return getAllByAction("update");        
    }
    final public List<Log> getAllAccioAdd() throws Exception {
        return getAllByAction("ADD");        
    }
    final public List<Log> getAllAccioLogged() throws Exception {
        return getAllByAction("LOGGED");        
    }
    final public List<Log> getAllAccioLoggedout() throws Exception {
        return getAllByAction("LOGGEDOUT");        
    }
   
    final public List<Log> getAllByAction(final String accio) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Log WHERE accio = :accio";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("accio", accio);
        List<Log> logs = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the results
        return logs;
    }
   
    final public List<Log> getAllLogins() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Log WHERE accio = :accio OR accio = :accio2";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("accio", "LOGGED");
        query.setParameter("accio2", "LOGGEDOUT");
        List<Log> logs = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the results
        return logs;
    }
    
    final public Log updateCustomerLog(final String companyCode) throws Exception {
        
        Log Log = new Log();
        Log.setCode(companyCode);
        Log.setType("CUSTOMER");
        Log.setAccio("update");
        Log.setDescrip("USER CREATED");        
        
        this.save(Log);
        
        return Log;
    }
    
    final public Log userLoggedToSystem() throws Exception {
        
        final String user = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getCode();
        
        Log Log = new Log();
        Log.setCode(user);
        Log.setType("USER");
        Log.setAccio("LOGGED");
        Log.setDescrip("USER LOGGED TO SYSTEM");        
        
        this.save(Log);
        
        return Log;
    }
    
    final public Log userLoggedOutToSystem() throws Exception {
        
        final String user = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getCode();
        
        Log Log = new Log();
        Log.setCode(user);
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
        likes.add("descrip");
        likes.add("accio");
        likes.add("falt");        
        
        final List<Log> items = (List<Log>) this.getAllLike(likes, search);
        
        return items;
    }
    
    final public List<Log> getByLikeEncabezadosByAccio(final String search, final String accio) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Log WHERE accio = :accio AND (code LIKE :code OR descrip LIKE :descrip)";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("accio", accio);
        query.setParameter("code","%" + search + "%");
        query.setParameter("descrip", "%" + search + "%");        
        List<Log> logs = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the results
        return logs;
    }
    
    final public List<Log> getByLikeEncabezadosRegistrosCreados(final String search) throws Exception{
        return getByLikeEncabezadosByAccio(search, "save");        
    }
    final public List<Log> getByLikeEncabezadosRegistrosActualizados(final String search) throws Exception{
        return getByLikeEncabezadosByAccio(search, "update");
    }
    final public List<Log> getByLikeEncabezadosLoginUsuarios(final String search) throws Exception{
        
        final List<Log> loginUsuarios = getByLikeEncabezadosByAccio(search, "LOGGED");
        final List<Log> loginoutUsuarios = getByLikeEncabezadosByAccio(search, "LOGGEDOUT");
        final List<Log> finalLoginUsuarios = new ArrayList<>();
        finalLoginUsuarios.addAll(loginUsuarios);
        finalLoginUsuarios.addAll(loginoutUsuarios);
        
        return finalLoginUsuarios;
    }
    final public List<Log> getByLikeEncabezadosCierreSesion(final String search) throws Exception{
        return getByLikeEncabezadosByAccio(search, "LOGGEDOUT");
    }
    final public List<Log> getByLikeEncabezadosInicioSesion(final String search) throws Exception{
        return getByLikeEncabezadosByAccio(search, "LOGGED");
    }
}