package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Partcomprs;

public class PartcomprssRepository extends Repository {

   public PartcomprssRepository() {
        super(Partcomprs.class);
    }

   @Override
   final public List<Partcomprs> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Partcomprs> records = (List<Partcomprs>) this.getAllLike(likes, search);
       
       return records;
   }

}