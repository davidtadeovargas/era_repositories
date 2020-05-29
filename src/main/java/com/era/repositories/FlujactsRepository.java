package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Flujact;

public class FlujactsRepository extends Repository {

   public FlujactsRepository() {
        super(Flujact.class);
    }

   @Override
   final public List<Flujact> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Flujact> records = (List<Flujact>) this.getAllLike(likes, search);
       
       return records;
   }

}