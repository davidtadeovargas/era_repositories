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

    public Banco getByAccount(final String account) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);       
        
        final Session Session = HibernateUtil.getSingleton().getSession();
        
        String hql = "FROM Banco WHERE cuentabanco = :account";
        Query query = Session.createQuery(hql);
        query.setParameter("account", account);
        Banco Banco = query.list().size() > 0 ? (Banco)query.list().get(0):null;
        
        //Close database
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
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