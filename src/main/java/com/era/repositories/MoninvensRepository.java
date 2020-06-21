package com.era.repositories;

import com.era.datamodels.enums.MovinvenType;
import com.era.models.Conceps;
import com.era.models.Existalma;
import java.util.List;
import java.util.ArrayList;
import com.era.models.Moninven;

public class MoninvensRepository extends Repository {

    public MoninvensRepository() {
        super(Moninven.class);
    }

    public Object addOrRemove(final Moninven Moninven, final MovinvenType MovinvenType) throws Exception {
        
        //Get the concept 
        final Conceps Concep = (Conceps)RepositoryFactory.getInstance().getConcepssRepository().getByCode(Moninven.getConcep());
        
        //Set the description
        Moninven.setDescrip(Concep.getDescrip());
        
        //Get the previous existence        
        Existalma Existalma = RepositoryFactory.getInstance().getExistalmasRepository().getByWarehouseAndProduct(Moninven.getAlma(), Moninven.getProd());
        
        //If not exists create the record        
        if(Existalma==null){
            Existalma = new Existalma();
            Existalma.setProd(Moninven.getProd());
            Existalma.setAlma(Moninven.getAlma());            
            Existalma.setExist(0);
            RepositoryFactory.getInstance().getExistalmasRepository().save(Existalma);
        }
        
        float newExistence;
        if(MovinvenType == MovinvenType.ENTRADA){
            newExistence = Existalma.getExist() + Moninven.getCant();
        }
        else{
            newExistence = Existalma.getExist() - Moninven.getCant();
        }            
        
        //Update the model
        Existalma.setExist(newExistence);
        RepositoryFactory.getInstance().getExistalmasRepository().update(Existalma);
        
        //Save the record
        return this.save(Moninven);
    }
        
    @Override
    final public List<Moninven> getByLikeEncabezados(final String search) throws Exception{

        final List<String> likes = new ArrayList<>();
        likes.add("falt");
        likes.add("fmod");

        final List<Moninven> records = (List<Moninven>) this.getAllLike(likes, search);

        return records;
    }
}