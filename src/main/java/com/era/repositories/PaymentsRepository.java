package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Payment;

public class PaymentsRepository extends Repository {

   public PaymentsRepository() {
        super(Payment.class);
    }

   @Override
   final public List<Payment> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Payment> records = (List<Payment>) this.getAllLike(likes, search);
       
       return records;
   }

}