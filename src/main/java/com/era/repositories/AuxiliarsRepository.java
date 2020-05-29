package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Auxiliar;

public class AuxiliarsRepository extends Repository {

   public AuxiliarsRepository() {
        super(Auxiliar.class);
    }

   @Override
   final public List<Auxiliar> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Auxiliar> records = (List<Auxiliar>) this.getAllLike(likes, search);
       
       return records;
   }

}