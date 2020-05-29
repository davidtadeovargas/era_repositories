package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.MovimientosAsientos;

public class MovimientosAsientossRepository extends Repository {

   public MovimientosAsientossRepository() {
        super(MovimientosAsientos.class);
    }

   @Override
   final public List<MovimientosAsientos> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<MovimientosAsientos> records = (List<MovimientosAsientos>) this.getAllLike(likes, search);
       
       return records;
   }

}