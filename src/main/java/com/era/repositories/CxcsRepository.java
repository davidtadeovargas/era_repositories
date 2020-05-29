package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Cxc;

public class CxcsRepository extends Repository {

   public CxcsRepository() {
        super(Cxc.class);
    }

   @Override
   final public List<Cxc> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Cxc> records = (List<Cxc>) this.getAllLike(likes, search);
       
       return records;
   }

}