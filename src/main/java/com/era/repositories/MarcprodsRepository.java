package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Marcprod;

public class MarcprodsRepository extends Repository {

   public MarcprodsRepository() {
        super(Marcprod.class);
    }

   @Override
   final public List<Marcprod> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Marcprod> records = (List<Marcprod>) this.getAllLike(likes, search);
       
       return records;
   }

}