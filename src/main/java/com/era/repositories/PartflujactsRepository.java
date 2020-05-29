package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Partflujact;

public class PartflujactsRepository extends Repository {

   public PartflujactsRepository() {
        super(Partflujact.class);
    }

   @Override
   final public List<Partflujact> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Partflujact> records = (List<Partflujact>) this.getAllLike(likes, search);
       
       return records;
   }

}