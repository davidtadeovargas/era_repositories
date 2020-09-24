package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.CPaymentForm;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;

public class PaymentFormsRepository extends Repository {

    public PaymentFormsRepository() {
        super(CPaymentForm.class);
    }

    @Override
    public Object getByCode(String code) throws Exception {
        
        //Open database
        openDatabase();
        
        String hql = "FROM CPaymentForm WHERE c_FormaPago = :c_FormaPago";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("c_FormaPago", code);
        CPaymentForm CPaymentForm = query.list().size() > 0 ? (CPaymentForm)query.list().get(0):null;
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return CPaymentForm;
    }
   
    
    public CPaymentForm getByCash() throws Exception {
        return (CPaymentForm)this.getByCode("01");
    }
    
    @Override
    final public List<CPaymentForm> getByLikeEncabezados(final String search) throws Exception{

        final List<String> likes = new ArrayList<>();
        likes.add("falt");
        likes.add("fmod");

        final List<CPaymentForm> records = (List<CPaymentForm>) this.getAllLike(likes, search);

        return records;
    }

}