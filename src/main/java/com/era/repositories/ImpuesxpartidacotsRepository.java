package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Impuesxpartidacot;

public class ImpuesxpartidacotsRepository extends Repository {

   public ImpuesxpartidacotsRepository() {
        super(Impuesxpartidacot.class);
    }

   @Override
   final public List<Impuesxpartidacot> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Impuesxpartidacot> records = (List<Impuesxpartidacot>) this.getAllLike(likes, search);
       
       return records;
   }

}