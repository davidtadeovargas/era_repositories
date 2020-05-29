package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Responsable;

public class ResponsablesRepository extends Repository {

   public ResponsablesRepository() {
        super(Responsable.class);
    }

   @Override
   final public List<Responsable> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Responsable> records = (List<Responsable>) this.getAllLike(likes, search);
       
       return records;
   }

}