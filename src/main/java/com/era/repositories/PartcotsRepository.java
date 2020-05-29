package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Partcot;

public class PartcotsRepository extends Repository {

   public PartcotsRepository() {
        super(Partcot.class);
    }

   @Override
   final public List<Partcot> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Partcot> records = (List<Partcot>) this.getAllLike(likes, search);
       
       return records;
   }

}