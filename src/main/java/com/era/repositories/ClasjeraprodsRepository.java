package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Clasjeraprod;

public class ClasjeraprodsRepository extends Repository {

   public ClasjeraprodsRepository() {
        super(Clasjeraprod.class);
    }

   @Override
   final public List<Clasjeraprod> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Clasjeraprod> records = (List<Clasjeraprod>) this.getAllLike(likes, search);
       
       return records;
   }

}