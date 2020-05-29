package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Pes;

public class PessRepository extends Repository {

   public PessRepository() {
        super(Pes.class);
    }

   @Override
   final public List<Pes> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Pes> records = (List<Pes>) this.getAllLike(likes, search);
       
       return records;
   }

}