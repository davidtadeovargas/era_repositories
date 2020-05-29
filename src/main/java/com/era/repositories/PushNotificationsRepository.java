package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.PushNotification;

public class PushNotificationsRepository extends Repository {

   public PushNotificationsRepository() {
        super(PushNotification.class);
    }

   @Override
   final public List<PushNotification> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<PushNotification> records = (List<PushNotification>) this.getAllLike(likes, search);
       
       return records;
   }

}