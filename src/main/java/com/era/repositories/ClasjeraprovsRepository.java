package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Clasjeraprov;

public class ClasjeraprovsRepository extends Repository {

   public ClasjeraprovsRepository() {
        super(Clasjeraprov.class);
    }

   @Override
   final public List<Clasjeraprov> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Clasjeraprov> records = (List<Clasjeraprov>) this.getAllLike(likes, search);
       
       return records;
   }

}