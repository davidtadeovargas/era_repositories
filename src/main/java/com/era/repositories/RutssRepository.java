package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Ruts;

public class RutssRepository extends Repository {

   public RutssRepository() {
        super(Ruts.class);
    }

   @Override
   final public List<Ruts> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Ruts> records = (List<Ruts>) this.getAllLike(likes, search);
       
       return records;
   }

}