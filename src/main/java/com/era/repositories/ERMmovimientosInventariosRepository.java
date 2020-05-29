package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.ERMmovimientosInventario;

public class ERMmovimientosInventariosRepository extends Repository {

   public ERMmovimientosInventariosRepository() {
        super(ERMmovimientosInventario.class);
    }

   @Override
   final public List<ERMmovimientosInventario> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<ERMmovimientosInventario> records = (List<ERMmovimientosInventario>) this.getAllLike(likes, search);
       
       return records;
   }

}