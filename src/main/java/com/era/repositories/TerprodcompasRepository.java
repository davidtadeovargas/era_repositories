package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Terprodcompa;

public class TerprodcompasRepository extends Repository {

   public TerprodcompasRepository() {
        super(Terprodcompa.class);
    }

   @Override
   final public List<Terprodcompa> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Terprodcompa> records = (List<Terprodcompa>) this.getAllLike(likes, search);
       
       return records;
   }

}