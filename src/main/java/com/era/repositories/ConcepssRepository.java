package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Conceps;

public class ConcepssRepository extends Repository {

   public ConcepssRepository() {
        super(Conceps.class);
    }

   @Override
   final public List<Conceps> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Conceps> records = (List<Conceps>) this.getAllLike(likes, search);
       
       return records;
   }

}