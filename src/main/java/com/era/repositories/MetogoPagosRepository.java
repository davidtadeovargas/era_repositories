package com.era.repositories;

import com.era.models.Company;
import java.util.List;
import java.util.ArrayList;
import com.era.models.MetogoPago;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;

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