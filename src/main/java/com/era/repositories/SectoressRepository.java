package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Sectores;

public class SectoressRepository extends Repository {

   public SectoressRepository() {
        super(Sectores.class);
    }

   @Override
   final public List<Sectores> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Sectores> records = (List<Sectores>) this.getAllLike(likes, search);
       
       return records;
   }

}