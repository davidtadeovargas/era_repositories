package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.ImpuesXProduct;

public class ImpuesXProductsRepository extends Repository {

   public ImpuesXProductsRepository() {
        super(ImpuesXProduct.class);
    }

   @Override
   final public List<ImpuesXProduct> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<ImpuesXProduct> records = (List<ImpuesXProduct>) this.getAllLike(likes, search);
       
       return records;
   }

}