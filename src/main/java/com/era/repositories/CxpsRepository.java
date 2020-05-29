package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Cxp;

public class CxpsRepository extends Repository {

   public CxpsRepository() {
        super(Cxp.class);
    }

   @Override
   final public List<Cxp> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Cxp> records = (List<Cxp>) this.getAllLike(likes, search);
       
       return records;
   }

}