package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Warehouse;

public class WarehousesRepository extends Repository {

    public WarehousesRepository() {
        super(Warehouse.class);
    }   
    
    public Warehouse getSalesWarehouse() throws Exception{
        return (Warehouse)this.getByCode("VTAS");
    }
    
    @Override
    final public List<Warehouse> getByLikeEncabezados(final String search) throws Exception{

        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("respon");
        likes.add("almadescrip");
        likes.add("falt");
        likes.add("fmod");

        final List<Warehouse> records = (List<Warehouse>) this.getAllLike(likes, search);

        return records;
    }
}