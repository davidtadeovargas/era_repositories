package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Line;

public class LinesRepository extends Repository {

   public LinesRepository() {
        super(Line.class);
    }

   @Override
   final public List<Line> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Line> records = (List<Line>) this.getAllLike(likes, search);
       
       return records;
   }

}