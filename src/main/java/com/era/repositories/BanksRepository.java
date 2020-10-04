package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Banks;

public class BanksRepository extends Repository {

   public BanksRepository() {
        super(Banks.class);
    }

   @Override
   final public List<Banks> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Banks> records = (List<Banks>) this.getAllLike(likes, search);
       
       return records;
   }

}