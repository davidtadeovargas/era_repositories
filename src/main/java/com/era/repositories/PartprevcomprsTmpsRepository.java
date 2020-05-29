package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.PartprevcomprsTmp;

public class PartprevcomprsTmpsRepository extends Repository {

   public PartprevcomprsTmpsRepository() {
        super(PartprevcomprsTmp.class);
    }

   @Override
   final public List<PartprevcomprsTmp> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<PartprevcomprsTmp> records = (List<PartprevcomprsTmp>) this.getAllLike(likes, search);
       
       return records;
   }

}