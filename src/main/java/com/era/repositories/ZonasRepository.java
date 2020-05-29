package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Zona;

public class ZonasRepository extends Repository {

   public ZonasRepository() {
        super(Zona.class);
    }

   @Override
   final public List<Zona> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Zona> records = (List<Zona>) this.getAllLike(likes, search);
       
       return records;
   }

}