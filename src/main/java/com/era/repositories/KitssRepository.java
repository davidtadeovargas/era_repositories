package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Kits;

public class KitssRepository extends Repository {

   public KitssRepository() {
        super(Kits.class);
    }

   @Override
   final public List<Kits> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Kits> records = (List<Kits>) this.getAllLike(likes, search);
       
       return records;
   }

}