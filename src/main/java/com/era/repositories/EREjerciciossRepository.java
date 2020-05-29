package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.EREjercicios;

public class EREjerciciossRepository extends Repository {

   public EREjerciciossRepository() {
        super(EREjercicios.class);
    }

   @Override
   final public List<EREjercicios> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<EREjercicios> records = (List<EREjercicios>) this.getAllLike(likes, search);
       
       return records;
   }

}