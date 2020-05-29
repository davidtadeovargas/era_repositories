package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Banco;

public class BancosRepository extends Repository {

   public BancosRepository() {
        super(Banco.class);
    }

   @Override
   final public List<Banco> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Banco> records = (List<Banco>) this.getAllLike(likes, search);
       
       return records;
   }

}