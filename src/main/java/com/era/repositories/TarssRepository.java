package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Tars;

public class TarssRepository extends Repository {

   public TarssRepository() {
        super(Tars.class);
    }

   @Override
   final public List<Tars> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Tars> records = (List<Tars>) this.getAllLike(likes, search);
       
       return records;
   }

}