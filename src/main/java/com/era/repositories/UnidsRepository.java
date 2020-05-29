package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Unid;

public class UnidsRepository extends Repository {

   public UnidsRepository() {
        super(Unid.class);
    }

   @Override
   final public List<Unid> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Unid> records = (List<Unid>) this.getAllLike(likes, search);
       
       return records;
   }

}