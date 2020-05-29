package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.CClaveUnidad;

public class CClaveUnidadsRepository extends Repository {

   public CClaveUnidadsRepository() {
        super(CClaveUnidad.class);
    }

   @Override
   final public List<CClaveUnidad> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<CClaveUnidad> records = (List<CClaveUnidad>) this.getAllLike(likes, search);
       
       return records;
   }

}