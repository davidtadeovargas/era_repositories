package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Msjs;

public class MsjssRepository extends Repository {

   public MsjssRepository() {
        super(Msjs.class);
    }

   @Override
   final public List<Msjs> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Msjs> records = (List<Msjs>) this.getAllLike(likes, search);
       
       return records;
   }

}