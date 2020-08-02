package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Coin;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class CoinsRepository extends Repository {

    public CoinsRepository() {
        super(Coin.class);
    }

    @Override
    public List<?> getAllBySearchFilter(final String search) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);       
        
        final Session Session = HibernateUtil.getSingleton().getSession();
        
        String hql = "FROM " + ClassEntity.getName() + " WHERE code LIKE:code OR description LIKE:description";
        Query query = Session.createQuery(hql);
        query.setParameter("code", "%" + search + "%");
        query.setParameter("description", "%" + search + "%");        
        List<?> records = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return records;
    }
    
    public void removeAllNational() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Coin where national = true";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);        
        List<Coin> coins = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Iterate all the coins
        for(Coin Coin_:coins){
            Coin_.setNational(false);
            this.update(Coin_);
        }
    }
    
    public void changeToNational(final String coinCode) throws Exception {
        
        final Coin Coin = (Coin)this.getByCode(coinCode);
        
        if(Coin!=null){
            Coin.setNational(true);
            this.update(Coin);
        }
    }
        
    public void saveOrUpdate(final Object Object) throws Exception{
        
        //Cast the model
        Coin Coin = (Coin)Object;
        
        //If the user wants to change the national coin
        if(Coin.isNational()){
         
            //Remove the national coin
            removeAllNational();
        }
                
        //Check if the coin exists
        final Coin Coin_ = (Coin)this.getByCode(Coin.getCode());
        
        //If exist update or save
        if(Coin_!=null){
            
            //Set model
            Coin_.setCode(Coin.getCode());
            Coin_.setDescription(Coin.getDescription());
            Coin_.setValue(Coin.getValue());
            Coin_.setNational(Coin.isNational());            
            
            this.update(Coin_);
        }
        else{
            this.save(Coin);
        }
    }
    
    final public Coin getNationalCoin() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Coin where national = true";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        Coin Coin = query.list().size() > 0 ? (Coin)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Coin;
    }
    
    @Override
    final public List<Coin> getByLikeEncabezados(final String search) throws Exception{

        final List<String> likes = new ArrayList<>();
        likes.add("code");
        likes.add("description");

        final List<Coin> records = (List<Coin>) this.getAllLike(likes, search);

        return records;
    }
}