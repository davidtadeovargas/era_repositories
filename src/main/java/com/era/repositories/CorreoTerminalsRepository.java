package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.CorreoTerminal;

public class CorreoTerminalsRepository extends Repository {

   public CorreoTerminalsRepository() {
        super(CorreoTerminal.class);
    }

   @Override
   final public List<CorreoTerminal> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<CorreoTerminal> records = (List<CorreoTerminal>) this.getAllLike(likes, search);
       
       return records;
   }

}