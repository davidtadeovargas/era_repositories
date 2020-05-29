package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Actfijcat;

public class ActfijcatsRepository extends Repository {

   public ActfijcatsRepository() {
        super(Actfijcat.class);
    }

   @Override
   final public List<Actfijcat> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Actfijcat> records = (List<Actfijcat>) this.getAllLike(likes, search);
       
       return records;
   }

}