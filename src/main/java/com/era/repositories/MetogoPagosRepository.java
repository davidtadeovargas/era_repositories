package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.MetogoPago;

public class MetogoPagosRepository extends Repository {

    public MetogoPagosRepository() {
        super(MetogoPago.class);
    }   
    
    @Override
    final public List<MetogoPago> getByLikeEncabezados(final String search) throws Exception{

        final List<String> likes = new ArrayList<>();
        likes.add("falt");
        likes.add("fmod");

        final List<MetogoPago> records = (List<MetogoPago>) this.getAllLike(likes, search);

        return records;
    }
}