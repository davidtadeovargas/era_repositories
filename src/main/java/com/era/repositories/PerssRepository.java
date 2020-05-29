package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Pers;

public class PerssRepository extends Repository {

   public PerssRepository() {
        super(Pers.class);
    }

   @Override
   final public List<Pers> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Pers> records = (List<Pers>) this.getAllLike(likes, search);
       
       return records;
   }

}