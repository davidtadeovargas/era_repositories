package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Ingres;

public class IngressRepository extends Repository {

   public IngressRepository() {
        super(Ingres.class);
    }

   @Override
   final public List<Ingres> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Ingres> records = (List<Ingres>) this.getAllLike(likes, search);
       
       return records;
   }

}