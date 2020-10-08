package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Banco;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class BancosRepository extends Repository {

    public BancosRepository() {
        super(Banco.class);
    }

    @Override
    public List<?> getAllBySearchFilter(final String search) throws Exception {
        
        //Open database
        openDatabase();       
        
        final Session Session = HibernateUtil.getSingleton().getSession();
        
        String hql = "FROM Banco WHERE cuentabanco LIKE:cuentabanco OR banco LIKE:banco OR descrip LIKE:descrip";
        Query query = Session.createQuery(hql);
        query.setParameter("cuentabanco", "%" + search + "%");
        query.setParameter("banco", "%" + search + "%");
        query.setParameter("descrip", "%" + search + "%");
        List<?> records = query.list();
        
        //Close database
        closeDatabase();
        
        //Return the result model
        return records;
    }
    
    public Banco getByAccount(final String account) throws Exception {
        
        //Open database
        openDatabase();
        
        final Session Session = HibernateUtil.getSingleton().getSession();
        
        String hql = "FROM Banco WHERE cuentabanco = :account";
        Query query = Session.createQuery(hql);
        query.setParameter("account", account);
        Banco Banco = query.list().size() > 0 ? (Banco)query.list().get(0):null;
        
        //Close database
        closeDatabase();
        
        //Return the result model
        return Banco;
    }
    
    @Override
    final public List<Banco> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("cuentabanco");
       likes.add("banco");
       likes.add("descrip");
       likes.add("falt");
       likes.add("fmod");
       
       final List<Banco> records = (List<Banco>) this.getAllLike(likes, search);
       
       return records;
    }

}