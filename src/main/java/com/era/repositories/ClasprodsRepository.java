package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Clasprod;

public class ClasprodsRepository extends Repository {

   public ClasprodsRepository() {
        super(Clasprod.class);
    }

   @Override
   final public List<Clasprod> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Clasprod> records = (List<Clasprod>) this.getAllLike(likes, search);
       
       return records;
   }

}