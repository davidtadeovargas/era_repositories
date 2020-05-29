package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Resplog;

public class ResplogsRepository extends Repository {

   public ResplogsRepository() {
        super(Resplog.class);
    }

   @Override
   final public List<Resplog> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Resplog> records = (List<Resplog>) this.getAllLike(likes, search);
       
       return records;
   }

}