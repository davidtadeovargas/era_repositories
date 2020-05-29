package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Cortszx;

public class CortszxsRepository extends Repository {

   public CortszxsRepository() {
        super(Cortszx.class);
    }

   @Override
   final public List<Cortszx> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Cortszx> records = (List<Cortszx>) this.getAllLike(likes, search);
       
       return records;
   }

}