package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.PartcomprsTmp;

public class PartcomprsTmpsRepository extends Repository {

   public PartcomprsTmpsRepository() {
        super(PartcomprsTmp.class);
    }

   @Override
   final public List<PartcomprsTmp> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<PartcomprsTmp> records = (List<PartcomprsTmp>) this.getAllLike(likes, search);
       
       return records;
   }

}