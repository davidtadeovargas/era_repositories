package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.DocumentosPago;

public class DocumentosPagosRepository extends Repository {

   public DocumentosPagosRepository() {
        super(DocumentosPago.class);
    }

   @Override
   final public List<DocumentosPago> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<DocumentosPago> records = (List<DocumentosPago>) this.getAllLike(likes, search);
       
       return records;
   }

}