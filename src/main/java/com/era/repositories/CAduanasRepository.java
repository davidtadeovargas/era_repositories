package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.CAduana;

public class CAduanasRepository extends Repository {

   public CAduanasRepository() {
        super(CAduana.class);
    }

   @Override
   final public List<CAduana> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<CAduana> records = (List<CAduana>) this.getAllLike(likes, search);
       
       return records;
   }

}