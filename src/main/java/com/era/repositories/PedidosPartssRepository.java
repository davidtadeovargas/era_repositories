package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.PedidosParts;

public class PedidosPartssRepository extends Repository {

   public PedidosPartssRepository() {
        super(PedidosParts.class);
    }

   @Override
   final public List<PedidosParts> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<PedidosParts> records = (List<PedidosParts>) this.getAllLike(likes, search);
       
       return records;
   }

}