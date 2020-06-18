package com.era.repositories;

import com.era.models.Moninven;
import java.util.List;
import java.util.ArrayList;
import com.era.models.Traspas;
import com.era.repositories.utils.HibernateUtil;

public class TraspassRepository extends Repository {

    public TraspassRepository() {
        super(Traspas.class);
    }

    public void traspass(final Traspas Traspas) throws Exception {
    
        HibernateUtil.getSingleton().openSessionInTransacction(ClassEntity);
        
        //Save the traspas
        this.save(Traspas);
        
        //Move existences from warehouses
        RepositoryFactory.getInstance().getExistalmasRepository().moveExistencesFromTo(Traspas.getCode(), Traspas.getAlma(), Traspas.getAlmaa(), Traspas.getUnid(), Traspas.getCantent());
        
        HibernateUtil.getSingleton().closeSessionInTransaction(ClassEntity);
    }
    
    @Override
    final public List<Traspas> getByLikeEncabezados(final String search) throws Exception{

        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("alma");
        likes.add("concep");       

        final List<Traspas> records = (List<Traspas>) this.getAllLike(likes, search);

        return records;
    }
}