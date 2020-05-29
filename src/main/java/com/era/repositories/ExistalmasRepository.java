package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Existalma;

public class ExistalmasRepository extends Repository {

   public ExistalmasRepository() {
        super(Existalma.class);
    }

   @Override
   final public List<Existalma> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Existalma> records = (List<Existalma>) this.getAllLike(likes, search);
       
       return records;
   }

}