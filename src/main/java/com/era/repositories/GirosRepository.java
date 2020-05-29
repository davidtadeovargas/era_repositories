package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Giro;

public class GirosRepository extends Repository {

   public GirosRepository() {
        super(Giro.class);
    }

   @Override
   final public List<Giro> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Giro> records = (List<Giro>) this.getAllLike(likes, search);
       
       return records;
   }

}