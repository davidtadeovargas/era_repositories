package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.ERPermisos;

public class ERPermisossRepository extends Repository {

   public ERPermisossRepository() {
        super(ERPermisos.class);
    }

   @Override
   final public List<ERPermisos> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<ERPermisos> records = (List<ERPermisos>) this.getAllLike(likes, search);
       
       return records;
   }

}