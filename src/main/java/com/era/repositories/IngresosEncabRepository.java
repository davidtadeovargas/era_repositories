/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.datamodels.enums.MovinvenType;
import com.era.models.Coin;
import com.era.models.Ingres;
import com.era.models.IngresosEncab;
import com.era.models.Moninven;
import com.era.repositories.utils.HibernateUtil;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class IngresosEncabRepository extends Repository {

    public IngresosEncabRepository() {
        super(IngresosEncab.class);
    }
    
    final public void saveIngres(final IngresosEncab IngresosEncab, final List<Ingres> items, final MovinvenType MovinvenType) throws Exception {
        
        HibernateUtil.getSingleton().openSessionInTransacction(ClassEntity);
        
        //Get the national tip cam
        final Coin Coin = RepositoryFactory.getInstance().getCoinsRepository().getNationalCoin();
        
        //Save the header
        this.save(IngresosEncab);
        
        //Save the items
        for(Ingres Ingres:items){
            
            //Relation            
            Ingres.setIdIngresCab(IngresosEncab.getId());
            
            //Set the concep
            Ingres.setConcep(IngresosEncab.getConcep());
            
            //Set the national exchange value
            Ingres.setTipcamnac(new BigDecimal(Coin.getValue(), MathContext.DECIMAL64));
            
            //Save             
            this.save(Ingres);
            
            //Determine input or output
            boolean entsal = MovinvenType == MovinvenType.ENTRADA;
            
            //Create the model
            final Moninven Moninven = new Moninven();
            Moninven.setConcep(IngresosEncab.getConcep());
            Moninven.setProd(Ingres.getProd());
            Moninven.setAlma(IngresosEncab.getAlma());
            Moninven.setEntsal(entsal);
            Moninven.setEmp("");
            Moninven.setNodoc("");
            Moninven.setNoser("");
            Moninven.setUnid(Ingres.getUnid());
            Moninven.setCant(Ingres.getCant());
            
            //Save the movement
            RepositoryFactory.getInstance().getMoninvensRepository().addOrRemove(Moninven,MovinvenType);
        }
        
        HibernateUtil.getSingleton().closeSessionInTransaction(ClassEntity);
    }
    
    final public IngresosEncab getByNoserNorefer(final String noser, final String norefer) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM IngresosEncab WHERE noser = :noser AND norefer = :norefer";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("noser", noser);
        query.setParameter("norefer", norefer);
        List<IngresosEncab> list = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return list.size()>0?list.get(0):null;
    }
    
    @Override
    final public List<IngresosEncab> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("alma");
        likes.add("concep");
        likes.add("norefer");
        likes.add("falt");
        likes.add("fmod");
        
        final List<IngresosEncab> items = (List<IngresosEncab>) this.getAllLike(likes, search);
        
        return items;
    }
    
}
