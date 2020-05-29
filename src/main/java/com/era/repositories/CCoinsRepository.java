package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.CCoin;

public class CCoinsRepository extends Repository {

   public CCoinsRepository() {
        super(CCoin.class);
    }

   @Override
   final public List<CCoin> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<CCoin> records = (List<CCoin>) this.getAllLike(likes, search);
       
       return records;
   }

}