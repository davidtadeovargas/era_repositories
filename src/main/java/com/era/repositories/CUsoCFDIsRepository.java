package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.CUsoCFDI;

public class CUsoCFDIsRepository extends Repository {

   public CUsoCFDIsRepository() {
        super(CUsoCFDI.class);
    }

   @Override
   final public List<CUsoCFDI> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<CUsoCFDI> records = (List<CUsoCFDI>) this.getAllLike(likes, search);
       
       return records;
   }

}