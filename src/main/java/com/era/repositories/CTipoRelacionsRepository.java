package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.CTipoRelacion;

public class CTipoRelacionsRepository extends Repository {

   public CTipoRelacionsRepository() {
        super(CTipoRelacion.class);
    }

   @Override
   final public List<CTipoRelacion> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<CTipoRelacion> records = (List<CTipoRelacion>) this.getAllLike(likes, search);
       
       return records;
   }

}