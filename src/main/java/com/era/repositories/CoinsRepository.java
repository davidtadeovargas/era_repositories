package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Coin;

public class CoinsRepository extends Repository {

   public CoinsRepository() {
        super(Coin.class);
    }

   @Override
   final public List<Coin> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Coin> records = (List<Coin>) this.getAllLike(likes, search);
       
       return records;
   }

}