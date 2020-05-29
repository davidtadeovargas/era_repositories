package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Supplier;

public class SuppliersRepository extends Repository {

   public SuppliersRepository() {
        super(Supplier.class);
    }

   @Override
   final public List<Supplier> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Supplier> records = (List<Supplier>) this.getAllLike(likes, search);
       
       return records;
   }

}