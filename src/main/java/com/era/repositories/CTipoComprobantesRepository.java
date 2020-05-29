package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.CTipoComprobante;

public class CTipoComprobantesRepository extends Repository {

   public CTipoComprobantesRepository() {
        super(CTipoComprobante.class);
    }

   @Override
   final public List<CTipoComprobante> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<CTipoComprobante> records = (List<CTipoComprobante>) this.getAllLike(likes, search);
       
       return records;
   }

}