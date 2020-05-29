package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Impuesxpartidaped;

public class ImpuesxpartidapedsRepository extends Repository {

   public ImpuesxpartidapedsRepository() {
        super(Impuesxpartidaped.class);
    }

   @Override
   final public List<Impuesxpartidaped> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Impuesxpartidaped> records = (List<Impuesxpartidaped>) this.getAllLike(likes, search);
       
       return records;
   }

}