package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Datoscp;

public class DatoscpsRepository extends Repository {

   public DatoscpsRepository() {
        super(Datoscp.class);
    }

   @Override
   final public List<Datoscp> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Datoscp> records = (List<Datoscp>) this.getAllLike(likes, search);
       
       return records;
   }

}