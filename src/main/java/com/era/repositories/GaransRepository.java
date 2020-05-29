package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Garan;

public class GaransRepository extends Repository {

   public GaransRepository() {
        super(Garan.class);
    }

   @Override
   final public List<Garan> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Garan> records = (List<Garan>) this.getAllLike(likes, search);
       
       return records;
   }

}