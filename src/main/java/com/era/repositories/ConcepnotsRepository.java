package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Concepnot;

public class ConcepnotsRepository extends Repository {

   public ConcepnotsRepository() {
        super(Concepnot.class);
    }

   @Override
   final public List<Concepnot> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Concepnot> records = (List<Concepnot>) this.getAllLike(likes, search);
       
       return records;
   }

}