package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.IngresosEncab;

public class IngresosEncabsRepository extends Repository {

   public IngresosEncabsRepository() {
        super(IngresosEncab.class);
    }

   @Override
   final public List<IngresosEncab> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<IngresosEncab> records = (List<IngresosEncab>) this.getAllLike(likes, search);
       
       return records;
   }

}