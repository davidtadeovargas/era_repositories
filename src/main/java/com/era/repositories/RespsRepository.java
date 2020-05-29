package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Resp;

public class RespsRepository extends Repository {

   public RespsRepository() {
        super(Resp.class);
    }

   @Override
   final public List<Resp> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Resp> records = (List<Resp>) this.getAllLike(likes, search);
       
       return records;
   }

}