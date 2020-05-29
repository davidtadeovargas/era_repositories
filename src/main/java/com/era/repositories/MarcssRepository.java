package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Marcs;

public class MarcssRepository extends Repository {

   public MarcssRepository() {
        super(Marcs.class);
    }

   @Override
   final public List<Marcs> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Marcs> records = (List<Marcs>) this.getAllLike(likes, search);
       
       return records;
   }

}