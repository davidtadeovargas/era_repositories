package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Conceppag;

public class ConceppagsRepository extends Repository {

   public ConceppagsRepository() {
        super(Conceppag.class);
    }

   @Override
   final public List<Conceppag> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Conceppag> records = (List<Conceppag>) this.getAllLike(likes, search);
       
       return records;
   }

}