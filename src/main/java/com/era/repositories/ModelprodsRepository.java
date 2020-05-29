package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Modelprod;

public class ModelprodsRepository extends Repository {

   public ModelprodsRepository() {
        super(Modelprod.class);
    }

   @Override
   final public List<Modelprod> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Modelprod> records = (List<Modelprod>) this.getAllLike(likes, search);
       
       return records;
   }

}