package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.DeliverAddressCustomer;

public class DeliverAddressCustomersRepository extends Repository {

   public DeliverAddressCustomersRepository() {
        super(DeliverAddressCustomer.class);
    }

   @Override
   final public List<DeliverAddressCustomer> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<DeliverAddressCustomer> records = (List<DeliverAddressCustomer>) this.getAllLike(likes, search);
       
       return records;
   }

}