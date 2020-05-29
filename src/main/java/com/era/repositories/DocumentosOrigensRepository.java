package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.DocumentosOrigen;

public class DocumentosOrigensRepository extends Repository {

   public DocumentosOrigensRepository() {
        super(DocumentosOrigen.class);
    }

   @Override
   final public List<DocumentosOrigen> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<DocumentosOrigen> records = (List<DocumentosOrigen>) this.getAllLike(likes, search);
       
       return records;
   }

}