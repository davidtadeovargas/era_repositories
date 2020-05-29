package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.ImpuestosXVenta;

public class ImpuestosXVentasRepository extends Repository {

   public ImpuestosXVentasRepository() {
        super(ImpuestosXVenta.class);
    }

   @Override
   final public List<ImpuestosXVenta> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<ImpuestosXVenta> records = (List<ImpuestosXVenta>) this.getAllLike(likes, search);
       
       return records;
   }

}