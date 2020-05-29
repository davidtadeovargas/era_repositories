package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Registros;

public class RegistrossRepository extends Repository {

   public RegistrossRepository() {
        super(Registros.class);
    }

   @Override
   final public List<Registros> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Registros> records = (List<Registros>) this.getAllLike(likes, search);
       
       return records;
   }

}