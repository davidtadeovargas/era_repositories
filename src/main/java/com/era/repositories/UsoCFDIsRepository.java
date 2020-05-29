package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.UsoCFDI;

public class UsoCFDIsRepository extends Repository {

   public UsoCFDIsRepository() {
        super(UsoCFDI.class);
    }

   @Override
   final public List<UsoCFDI> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<UsoCFDI> records = (List<UsoCFDI>) this.getAllLike(likes, search);
       
       return records;
   }

}