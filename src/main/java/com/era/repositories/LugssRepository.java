package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Lugs;

public class LugssRepository extends Repository {

   public LugssRepository() {
        super(Lugs.class);
    }

   @Override
   final public List<Lugs> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Lugs> records = (List<Lugs>) this.getAllLike(likes, search);
       
       return records;
   }

}