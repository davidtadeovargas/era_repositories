package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Asocdesc;

public class AsocdescsRepository extends Repository {

   public AsocdescsRepository() {
        super(Asocdesc.class);
    }

   @Override
   final public List<Asocdesc> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Asocdesc> records = (List<Asocdesc>) this.getAllLike(likes, search);
       
       return records;
   }

}