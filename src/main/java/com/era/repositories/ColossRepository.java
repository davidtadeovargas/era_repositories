package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Colos;

public class ColossRepository extends Repository {

   public ColossRepository() {
        super(Colos.class);
    }

   @Override
   final public List<Colos> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Colos> records = (List<Colos>) this.getAllLike(likes, search);
       
       return records;
   }

}