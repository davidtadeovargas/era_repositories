package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Tall;

public class TallsRepository extends Repository {

   public TallsRepository() {
        super(Tall.class);
    }

   @Override
   final public List<Tall> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Tall> records = (List<Tall>) this.getAllLike(likes, search);
       
       return records;
   }

}