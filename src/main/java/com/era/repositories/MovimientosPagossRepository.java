package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.MovimientosPagos;

public class MovimientosPagossRepository extends Repository {

   public MovimientosPagossRepository() {
        super(MovimientosPagos.class);
    }

   @Override
   final public List<MovimientosPagos> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<MovimientosPagos> records = (List<MovimientosPagos>) this.getAllLike(likes, search);
       
       return records;
   }

}