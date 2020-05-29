package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Aduana;

public class AduanasRepository extends Repository {

   public AduanasRepository() {
        super(Aduana.class);
    }

   @Override
   final public List<Aduana> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Aduana> records = (List<Aduana>) this.getAllLike(likes, search);
       
       return records;
   }

}