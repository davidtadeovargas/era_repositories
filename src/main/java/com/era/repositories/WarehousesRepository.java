package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Warehouse;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class WarehousesRepository extends Repository {

    public WarehousesRepository() {
        super(Warehouse.class);
    }   
    
    @Override
    public List<?> getAllBySearchFilter(final String search) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);       
        
        final Session Session = HibernateUtil.getSingleton().getSession();
        
        String hql = "FROM " + ClassEntity.getName() + " WHERE code LIKE:code OR responsable LIKE:responsable OR description LIKE:description";
        Query query = Session.createQuery(hql);
        query.setParameter("code", "%" + search + "%");
        query.setParameter("responsable", "%" + search + "%");
        query.setParameter("description", "%" + search + "%");
        List<?> records = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return records;
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