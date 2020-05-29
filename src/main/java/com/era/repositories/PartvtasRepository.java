package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Partvta;

public class PartvtasRepository extends Repository {

   public PartvtasRepository() {
        super(Partvta.class);
    }

   @Override
   final public List<Partvta> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Partvta> records = (List<Partvta>) this.getAllLike(likes, search);
       
       return records;
   }

}