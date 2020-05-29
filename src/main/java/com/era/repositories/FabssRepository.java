package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Fabs;

public class FabssRepository extends Repository {

   public FabssRepository() {
        super(Fabs.class);
    }

   @Override
   final public List<Fabs> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Fabs> records = (List<Fabs>) this.getAllLike(likes, search);
       
       return records;
   }

}