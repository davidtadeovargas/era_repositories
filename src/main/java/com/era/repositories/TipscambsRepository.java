package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Tipscamb;

public class TipscambsRepository extends Repository {

   public TipscambsRepository() {
        super(Tipscamb.class);
    }

   @Override
   final public List<Tipscamb> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Tipscamb> records = (List<Tipscamb>) this.getAllLike(likes, search);
       
       return records;
   }

}