package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Tax;

public class TaxsRepository extends Repository {

   public TaxsRepository() {
        super(Tax.class);
    }

   @Override
   final public List<Tax> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Tax> records = (List<Tax>) this.getAllLike(likes, search);
       
       return records;
   }

}