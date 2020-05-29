package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Ords;

public class OrdssRepository extends Repository {

   public OrdssRepository() {
        super(Ords.class);
    }

   @Override
   final public List<Ords> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Ords> records = (List<Ords>) this.getAllLike(likes, search);
       
       return records;
   }

}