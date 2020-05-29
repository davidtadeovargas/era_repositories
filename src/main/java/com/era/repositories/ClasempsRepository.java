package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Clasemp;

public class ClasempsRepository extends Repository {

   public ClasempsRepository() {
        super(Clasemp.class);
    }

   @Override
   final public List<Clasemp> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Clasemp> records = (List<Clasemp>) this.getAllLike(likes, search);
       
       return records;
   }

}