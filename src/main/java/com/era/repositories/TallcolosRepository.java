package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Tallcolo;

public class TallcolosRepository extends Repository {

   public TallcolosRepository() {
        super(Tallcolo.class);
    }

   @Override
   final public List<Tallcolo> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Tallcolo> records = (List<Tallcolo>) this.getAllLike(likes, search);
       
       return records;
   }

}