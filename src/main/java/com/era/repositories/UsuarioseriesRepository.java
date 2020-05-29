package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Usuarioserie;

public class UsuarioseriesRepository extends Repository {

   public UsuarioseriesRepository() {
        super(Usuarioserie.class);
    }

   @Override
   final public List<Usuarioserie> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Usuarioserie> records = (List<Usuarioserie>) this.getAllLike(likes, search);
       
       return records;
   }

}