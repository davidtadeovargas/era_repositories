package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Facturas;

public class FacturassRepository extends Repository {

   public FacturassRepository() {
        super(Facturas.class);
    }

   @Override
   final public List<Facturas> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Facturas> records = (List<Facturas>) this.getAllLike(likes, search);
       
       return records;
   }

}