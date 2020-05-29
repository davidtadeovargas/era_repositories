package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Pedidos;

public class PedidossRepository extends Repository {

   public PedidossRepository() {
        super(Pedidos.class);
    }

   @Override
   final public List<Pedidos> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Pedidos> records = (List<Pedidos>) this.getAllLike(likes, search);
       
       return records;
   }

}