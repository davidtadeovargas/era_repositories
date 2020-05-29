package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Contras;

public class ContrassRepository extends Repository {

   public ContrassRepository() {
        super(Contras.class);
    }

   @Override
   final public List<Contras> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Contras> records = (List<Contras>) this.getAllLike(likes, search);
       
       return records;
   }

}