package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Rubr;

public class RubrsRepository extends Repository {

   public RubrsRepository() {
        super(Rubr.class);
    }

   @Override
   final public List<Rubr> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Rubr> records = (List<Rubr>) this.getAllLike(likes, search);
       
       return records;
   }

}