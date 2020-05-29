package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Prodpart;

public class ProdpartsRepository extends Repository {

   public ProdpartsRepository() {
        super(Prodpart.class);
    }

   @Override
   final public List<Prodpart> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Prodpart> records = (List<Prodpart>) this.getAllLike(likes, search);
       
       return records;
   }

}