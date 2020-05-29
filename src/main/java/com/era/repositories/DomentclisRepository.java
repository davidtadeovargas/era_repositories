package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Domentcli;

public class DomentclisRepository extends Repository {

   public DomentclisRepository() {
        super(Domentcli.class);
    }

   @Override
   final public List<Domentcli> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Domentcli> records = (List<Domentcli>) this.getAllLike(likes, search);
       
       return records;
   }

}