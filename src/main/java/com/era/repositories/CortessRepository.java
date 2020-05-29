package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Cortes;

public class CortessRepository extends Repository {

   public CortessRepository() {
        super(Cortes.class);
    }

   @Override
   final public List<Cortes> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Cortes> records = (List<Cortes>) this.getAllLike(likes, search);
       
       return records;
   }

}