package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Serieprod;

public class SerieprodsRepository extends Repository {

   public SerieprodsRepository() {
        super(Serieprod.class);
    }

   @Override
   final public List<Serieprod> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Serieprod> records = (List<Serieprod>) this.getAllLike(likes, search);
       
       return records;
   }

}