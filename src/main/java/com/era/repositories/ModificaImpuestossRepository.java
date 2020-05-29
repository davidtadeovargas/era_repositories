package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.ModificaImpuestos;

public class ModificaImpuestossRepository extends Repository {

   public ModificaImpuestossRepository() {
        super(ModificaImpuestos.class);
    }

   @Override
   final public List<ModificaImpuestos> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<ModificaImpuestos> records = (List<ModificaImpuestos>) this.getAllLike(likes, search);
       
       return records;
   }

}