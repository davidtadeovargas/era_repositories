package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Partprevcomprs;

public class PartprevcomprssRepository extends Repository {

   public PartprevcomprssRepository() {
        super(Partprevcomprs.class);
    }

   @Override
   final public List<Partprevcomprs> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Partprevcomprs> records = (List<Partprevcomprs>) this.getAllLike(likes, search);
       
       return records;
   }

}