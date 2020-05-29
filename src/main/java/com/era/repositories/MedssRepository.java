package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Meds;

public class MedssRepository extends Repository {

   public MedssRepository() {
        super(Meds.class);
    }

   @Override
   final public List<Meds> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Meds> records = (List<Meds>) this.getAllLike(likes, search);
       
       return records;
   }

}