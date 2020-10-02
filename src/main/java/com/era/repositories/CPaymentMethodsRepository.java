package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.CPaymentMethod;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;

public class CPaymentMethodsRepository extends Repository {

    public CPaymentMethodsRepository() {
        super(CPaymentMethod.class);
    }

    final public CPaymentMethod getUnaSolExhibicion() throws Exception {
        
        //Open database
        openDatabase();
        
        String hql = "FROM CPaymentMethod where code = :code";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("code", "PUE");
        CPaymentMethod CPaymentMethod = query.list().size() > 0 ? (CPaymentMethod)query.list().get(0):null;
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return CPaymentMethod;
    }
    
    
    final public String getUnaSolExhibicionString() throws Exception {        
        return "PUE";
    }
   
    final public CPaymentMethod getParcialidades() throws Exception {
        
        //Open database
        openDatabase();
        
        String hql = "FROM CPaymentMethod where code = :code";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("code", "PPD");
        CPaymentMethod CPaymentMethod = query.list().size() > 0 ? (CPaymentMethod)query.list().get(0):null;
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return CPaymentMethod;
    }
    
    final public String getParcialidadesString() throws Exception {        
        return "PPD";
    }
    
   @Override
   final public List<CPaymentMethod> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<CPaymentMethod> records = (List<CPaymentMethod>) this.getAllLike(likes, search);
       
       return records;
   }

}