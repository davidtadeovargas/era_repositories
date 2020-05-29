package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Maxminconf;

public class MaxminconfsRepository extends Repository {

   public MaxminconfsRepository() {
        super(Maxminconf.class);
    }

   @Override
   final public List<Maxminconf> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Maxminconf> records = (List<Maxminconf>) this.getAllLike(likes, search);
       
       return records;
   }

}