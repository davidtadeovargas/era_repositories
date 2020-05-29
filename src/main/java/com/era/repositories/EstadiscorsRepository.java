package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Estadiscor;

public class EstadiscorsRepository extends Repository {

   public EstadiscorsRepository() {
        super(Estadiscor.class);
    }

   @Override
   final public List<Estadiscor> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Estadiscor> records = (List<Estadiscor>) this.getAllLike(likes, search);
       
       return records;
   }

}