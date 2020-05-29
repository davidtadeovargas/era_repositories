package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.UserPermission;

public class UserPermissionsRepository extends Repository {

   public UserPermissionsRepository() {
        super(UserPermission.class);
    }

   @Override
   final public List<UserPermission> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<UserPermission> records = (List<UserPermission>) this.getAllLike(likes, search);
       
       return records;
   }

}