package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Clasificacion;

public class ClasificacionsRepository extends Repository {

   public ClasificacionsRepository() {
        super(Clasificacion.class);
    }

   @Override
   final public List<Clasificacion> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Clasificacion> records = (List<Clasificacion>) this.getAllLike(likes, search);
       
       return records;
   }

}