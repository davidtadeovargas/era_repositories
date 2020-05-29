package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Tipactfij;

public class TipactfijsRepository extends Repository {

   public TipactfijsRepository() {
        super(Tipactfij.class);
    }

   @Override
   final public List<Tipactfij> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Tipactfij> records = (List<Tipactfij>) this.getAllLike(likes, search);
       
       return records;
   }

}