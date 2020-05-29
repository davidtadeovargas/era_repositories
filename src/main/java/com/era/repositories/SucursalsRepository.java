package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Sucursal;

public class SucursalsRepository extends Repository {

   public SucursalsRepository() {
        super(Sucursal.class);
    }

   @Override
   final public List<Sucursal> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Sucursal> records = (List<Sucursal>) this.getAllLike(likes, search);
       
       return records;
   }

}