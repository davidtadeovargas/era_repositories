package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Subramos;

public class SubramossRepository extends Repository {

   public SubramossRepository() {
        super(Subramos.class);
    }

   @Override
   final public List<Subramos> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Subramos> records = (List<Subramos>) this.getAllLike(likes, search);
       
       return records;
   }

}