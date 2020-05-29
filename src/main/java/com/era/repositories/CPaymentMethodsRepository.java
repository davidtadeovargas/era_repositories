package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.CPaymentMethod;

public class CPaymentMethodsRepository extends Repository {

   public CPaymentMethodsRepository() {
        super(CPaymentMethod.class);
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