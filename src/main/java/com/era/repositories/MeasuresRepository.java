package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Measure;

public class MeasuresRepository extends Repository {

   public MeasuresRepository() {
        super(Measure.class);
    }

   @Override
   final public List<Measure> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Measure> records = (List<Measure>) this.getAllLike(likes, search);
       
       return records;
   }

}