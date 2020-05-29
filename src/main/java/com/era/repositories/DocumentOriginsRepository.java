package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.DocumentOrigin;

public class DocumentOriginsRepository extends Repository {

   public DocumentOriginsRepository() {
        super(DocumentOrigin.class);
    }

   @Override
   final public List<DocumentOrigin> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<DocumentOrigin> records = (List<DocumentOrigin>) this.getAllLike(likes, search);
       
       return records;
   }

}