package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Costs;

public class CostssRepository extends Repository {

   public CostssRepository() {
        super(Costs.class);
    }

   @Override
   final public List<Costs> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Costs> records = (List<Costs>) this.getAllLike(likes, search);
       
       return records;
   }

}