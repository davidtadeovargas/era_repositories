package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Clasjeracli;

public class ClasjeraclisRepository extends Repository {

   public ClasjeraclisRepository() {
        super(Clasjeracli.class);
    }

   @Override
   final public List<Clasjeracli> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Clasjeracli> records = (List<Clasjeracli>) this.getAllLike(likes, search);
       
       return records;
   }

}