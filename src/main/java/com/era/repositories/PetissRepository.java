package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Petis;

public class PetissRepository extends Repository {

   public PetissRepository() {
        super(Petis.class);
    }

   @Override
   final public List<Petis> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Petis> records = (List<Petis>) this.getAllLike(likes, search);
       
       return records;
   }

}