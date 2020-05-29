package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.GeneralConfig;

public class GeneralConfigsRepository extends Repository {

   public GeneralConfigsRepository() {
        super(GeneralConfig.class);
    }

   @Override
   final public List<GeneralConfig> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<GeneralConfig> records = (List<GeneralConfig>) this.getAllLike(likes, search);
       
       return records;
   }

}