package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Prevcomprs;

public class PrevcomprssRepository extends Repository {

   public PrevcomprssRepository() {
        super(Prevcomprs.class);
    }

   @Override
   final public List<Prevcomprs> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Prevcomprs> records = (List<Prevcomprs>) this.getAllLike(likes, search);
       
       return records;
   }

}