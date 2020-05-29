package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.ImpuestosXCompra;

public class ImpuestosXComprasRepository extends Repository {

   public ImpuestosXComprasRepository() {
        super(ImpuestosXCompra.class);
    }

   @Override
   final public List<ImpuestosXCompra> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<ImpuestosXCompra> records = (List<ImpuestosXCompra>) this.getAllLike(likes, search);
       
       return records;
   }

}