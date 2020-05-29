package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.HistAntiguedaddesaldo;

public class HistAntiguedaddesaldosRepository extends Repository {

   public HistAntiguedaddesaldosRepository() {
        super(HistAntiguedaddesaldo.class);
    }

   @Override
   final public List<HistAntiguedaddesaldo> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<HistAntiguedaddesaldo> records = (List<HistAntiguedaddesaldo>) this.getAllLike(likes, search);
       
       return records;
   }

}