package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Fluj;

public class FlujsRepository extends Repository {

   public FlujsRepository() {
        super(Fluj.class);
    }

   @Override
   final public List<Fluj> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Fluj> records = (List<Fluj>) this.getAllLike(likes, search);
       
       return records;
   }

}