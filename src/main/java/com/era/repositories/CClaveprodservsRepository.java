package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.CClaveprodserv;

public class CClaveprodservsRepository extends Repository {

   public CClaveprodservsRepository() {
        super(CClaveprodserv.class);
    }

   @Override
   final public List<CClaveprodserv> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<CClaveprodserv> records = (List<CClaveprodserv>) this.getAllLike(likes, search);
       
       return records;
   }

}