package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Partords;

public class PartordssRepository extends Repository {

   public PartordssRepository() {
        super(Partords.class);
    }

   @Override
   final public List<Partords> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Partords> records = (List<Partords>) this.getAllLike(likes, search);
       
       return records;
   }

}