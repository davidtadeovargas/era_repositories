package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Clasprov;

public class ClasprovsRepository extends Repository {

   public ClasprovsRepository() {
        super(Clasprov.class);
    }

   @Override
   final public List<Clasprov> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Clasprov> records = (List<Clasprov>) this.getAllLike(likes, search);
       
       return records;
   }

}