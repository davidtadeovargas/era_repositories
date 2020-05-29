package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.CuentasContables;

public class CuentasContablessRepository extends Repository {

   public CuentasContablessRepository() {
        super(CuentasContables.class);
    }

   @Override
   final public List<CuentasContables> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<CuentasContables> records = (List<CuentasContables>) this.getAllLike(likes, search);
       
       return records;
   }

}