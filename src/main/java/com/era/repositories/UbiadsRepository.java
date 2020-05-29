package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Ubiad;

public class UbiadsRepository extends Repository {

   public UbiadsRepository() {
        super(Ubiad.class);
    }

   @Override
   final public List<Ubiad> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Ubiad> records = (List<Ubiad>) this.getAllLike(likes, search);
       
       return records;
   }

}