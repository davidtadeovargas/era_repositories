package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Controlexportar;

public class ControlexportarsRepository extends Repository {

   public ControlexportarsRepository() {
        super(Controlexportar.class);
    }

   @Override
   final public List<Controlexportar> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Controlexportar> records = (List<Controlexportar>) this.getAllLike(likes, search);
       
       return records;
   }

}