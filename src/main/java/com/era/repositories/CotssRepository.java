package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Cots;

public class CotssRepository extends Repository {

   public CotssRepository() {
        super(Cots.class);
    }

   @Override
   final public List<Cots> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Cots> records = (List<Cots>) this.getAllLike(likes, search);
       
       return records;
   }

}