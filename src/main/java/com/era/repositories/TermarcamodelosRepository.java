package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Termarcamodelo;

public class TermarcamodelosRepository extends Repository {

   public TermarcamodelosRepository() {
        super(Termarcamodelo.class);
    }

   @Override
   final public List<Termarcamodelo> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Termarcamodelo> records = (List<Termarcamodelo>) this.getAllLike(likes, search);
       
       return records;
   }

}