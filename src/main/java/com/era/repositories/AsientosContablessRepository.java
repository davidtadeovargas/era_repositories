package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.AsientosContables;

public class AsientosContablessRepository extends Repository {

   public AsientosContablessRepository() {
        super(AsientosContables.class);
    }

   @Override
   final public List<AsientosContables> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<AsientosContables> records = (List<AsientosContables>) this.getAllLike(likes, search);
       
       return records;
   }

}