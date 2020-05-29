package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.PaymentForm;

public class PaymentFormsRepository extends Repository {

   public PaymentFormsRepository() {
        super(PaymentForm.class);
    }

   @Override
   final public List<PaymentForm> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<PaymentForm> records = (List<PaymentForm>) this.getAllLike(likes, search);
       
       return records;
   }

}