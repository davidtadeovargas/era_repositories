package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Model;

public class ModelsRepository extends Repository {

   public ModelsRepository() {
        super(Model.class);
    }

   @Override
   final public List<Model> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Model> records = (List<Model>) this.getAllLike(likes, search);
       
       return records;
   }

}