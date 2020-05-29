package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.CFDIRelacionadosPago;

public class CFDIRelacionadosPagosRepository extends Repository {

   public CFDIRelacionadosPagosRepository() {
        super(CFDIRelacionadosPago.class);
    }

   @Override
   final public List<CFDIRelacionadosPago> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<CFDIRelacionadosPago> records = (List<CFDIRelacionadosPago>) this.getAllLike(likes, search);
       
       return records;
   }

}