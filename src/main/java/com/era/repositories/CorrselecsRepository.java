package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Corrselec;

public class CorrselecsRepository extends Repository {

   public CorrselecsRepository() {
        super(Corrselec.class);
    }

   @Override
   final public List<Corrselec> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Corrselec> records = (List<Corrselec>) this.getAllLike(likes, search);
       
       return records;
   }

}