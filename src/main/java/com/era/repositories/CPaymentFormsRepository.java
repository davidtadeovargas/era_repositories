package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.CPaymentForm;

public class CPaymentFormsRepository extends Repository {

   public CPaymentFormsRepository() {
        super(CPaymentForm.class);
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