package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Anaqs;

public class AnaqssRepository extends Repository {

   public AnaqssRepository() {
        super(Anaqs.class);
    }

   @Override
   final public List<Anaqs> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Anaqs> records = (List<Anaqs>) this.getAllLike(likes, search);
       
       return records;
   }

}