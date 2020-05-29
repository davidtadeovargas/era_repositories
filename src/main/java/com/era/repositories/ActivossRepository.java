package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Activos;

public class ActivossRepository extends Repository {

   public ActivossRepository() {
        super(Activos.class);
    }

   @Override
   final public List<Activos> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Activos> records = (List<Activos>) this.getAllLike(likes, search);
       
       return records;
   }

}