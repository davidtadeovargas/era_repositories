package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Traspas;

public class TraspassRepository extends Repository {

   public TraspassRepository() {
        super(Traspas.class);
    }

   @Override
   final public List<Traspas> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Traspas> records = (List<Traspas>) this.getAllLike(likes, search);
       
       return records;
   }

}