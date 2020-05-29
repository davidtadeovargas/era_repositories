package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Grals;

public class GralssRepository extends Repository {

   public GralssRepository() {
        super(Grals.class);
    }

   @Override
   final public List<Grals> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Grals> records = (List<Grals>) this.getAllLike(likes, search);
       
       return records;
   }

}