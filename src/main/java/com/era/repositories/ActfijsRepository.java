package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Actfij;

public class ActfijsRepository extends Repository {

   public ActfijsRepository() {
        super(Actfij.class);
    }

   @Override
   final public List<Actfij> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Actfij> records = (List<Actfij>) this.getAllLike(likes, search);
       
       return records;
   }

}