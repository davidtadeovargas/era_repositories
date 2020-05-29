package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Comprs;

public class ComprssRepository extends Repository {

   public ComprssRepository() {
        super(Comprs.class);
    }

   @Override
   final public List<Comprs> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Comprs> records = (List<Comprs>) this.getAllLike(likes, search);
       
       return records;
   }

}