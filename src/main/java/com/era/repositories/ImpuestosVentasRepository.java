package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.ImpuestosVenta;

public class ImpuestosVentasRepository extends Repository {

   public ImpuestosVentasRepository() {
        super(ImpuestosVenta.class);
    }

   @Override
   final public List<ImpuestosVenta> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<ImpuestosVenta> records = (List<ImpuestosVenta>) this.getAllLike(likes, search);
       
       return records;
   }

}