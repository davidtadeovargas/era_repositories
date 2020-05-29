package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.DocumentosContabilizados;

public class DocumentosContabilizadossRepository extends Repository {

   public DocumentosContabilizadossRepository() {
        super(DocumentosContabilizados.class);
    }

   @Override
   final public List<DocumentosContabilizados> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<DocumentosContabilizados> records = (List<DocumentosContabilizados>) this.getAllLike(likes, search);
       
       return records;
   }

}