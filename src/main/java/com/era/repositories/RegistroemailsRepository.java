package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Registroemail;

public class RegistroemailsRepository extends Repository {

   public RegistroemailsRepository() {
        super(Registroemail.class);
    }

   @Override
   final public List<Registroemail> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Registroemail> records = (List<Registroemail>) this.getAllLike(likes, search);
       
       return records;
   }

}