package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Compa;

public class CompasRepository extends Repository {

   public CompasRepository() {
        super(Compa.class);
    }

   @Override
   final public List<Compa> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Compa> records = (List<Compa>) this.getAllLike(likes, search);
       
       return records;
   }

}