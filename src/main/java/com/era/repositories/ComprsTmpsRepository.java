package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.ComprsTmp;

public class ComprsTmpsRepository extends Repository {

   public ComprsTmpsRepository() {
        super(ComprsTmp.class);
    }

   @Override
   final public List<ComprsTmp> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<ComprsTmp> records = (List<ComprsTmp>) this.getAllLike(likes, search);
       
       return records;
   }

}