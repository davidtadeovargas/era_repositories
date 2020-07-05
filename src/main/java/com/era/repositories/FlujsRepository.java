package com.era.repositories;

import com.era.models.Coin;
import java.util.List;
import java.util.ArrayList;
import com.era.models.Fluj;
import com.era.repositories.utils.HibernateUtil;
import java.math.BigDecimal;
import org.hibernate.Query;

public class FlujsRepository extends Repository {

    public FlujsRepository() {
        super(Fluj.class);
    }

    public Fluj save(Fluj Fluj, final String entsal, final TypePayment TypePayment) throws Exception {
    
        switch(TypePayment){
            
            case CASH:
                Fluj.setConcep("EFE");
                break;
                
            case CARD_DEBIT:
                Fluj.setConcep("TARDEB");
                break;
               
            case CARD_CREDIT:
                Fluj.setConcep("TARCRED");
                break;
               
            case INITIAL_CASH:
                Fluj.setConcep("INITIAL_CASH");
                break;
        }
                
        Fluj.setModd("");
        Fluj.setCorta(false); //Pending
        
        Fluj.setIng_eg(entsal);
        
        return (Fluj)super.save(Fluj);
    }
    
    public Fluj saveIngreCaj(final BigDecimal initialAmount) throws Exception {
    
        //Get national coin
        final Coin Coin = (Coin)RepositoryFactory.getInstance().getCoinsRepository().getNationalCoin();
        
        final Fluj Fluj = new Fluj();
        Fluj.setConcep("INITIAL_CASH");                
        Fluj.setModd("");
        Fluj.setCorta(false); //Pending
        Fluj.setIng_eg("ent");
        Fluj.setImpo(initialAmount);
        Fluj.setMon(Coin.getCode());
        Fluj.setNorefer("");
        Fluj.setTipdoc("");
        
        return (Fluj)super.save(Fluj);
    }
    
    public void updateAllStillNotCuttedWithCortNumber(final int cortNumber) throws Exception {    
        this.updateSQL("UPDATE Fluj SET ncortz = " + cortNumber + " WHERE corta = false");
    }
    
    final public List<Fluj> getAllPendingCut() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Fluj WHERE corta = true";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);        
        List<Fluj> flujs = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return flujs;
    }
    
    public BigDecimal getTotalSalesPendingCortByConcep(final String concep) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Fluj WHERE corta = false AND concep = :concep";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("concep", concep);
        List<Fluj> flujs = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Get the total
        BigDecimal total = BigDecimal.ZERO;
        for(Fluj Fluj:flujs){
            total = total.add(Fluj.getImpo());
        }
        
        //Return the result model
        return total;
    }
    
    public BigDecimal getTotalSalesPendingCortInCash() throws Exception {
        return getTotalSalesPendingCortByConcep("EFE");        
    }
    public BigDecimal getTotalSalesPendingCortInCardDebit() throws Exception {
        return getTotalSalesPendingCortByConcep("TARDEB");        
    }
    public BigDecimal getTotalSalesPendingCortInCardCredit() throws Exception {
        return getTotalSalesPendingCortByConcep("TARCRED");        
    }
    public BigDecimal getTotalExistenceMoneyInCasher() throws Exception {
        return getTotalSalesPendingCortByConcep("INITIAL_CASH");        
    }
            
    public boolean existsMoneyInCasherForNewCort() throws Exception {
        BigDecimal total = getTotalSalesPendingCortByConcep("INITIAL_CASH");
        return total.doubleValue()>0;
    }
    
    public Fluj saveEnt(Fluj Fluj,TypePayment TypePayment) throws Exception {
        return this.save(Fluj, "ent", TypePayment);
    }
    public Fluj saveSal(Fluj Fluj,TypePayment TypePayment) throws Exception {
        return this.save(Fluj, "sal",TypePayment);
    }
    
    @Override
    final public List<Fluj> getByLikeEncabezados(final String search) throws Exception{

        final List<String> likes = new ArrayList<>();
        likes.add("falt");
        likes.add("fmod");

        final List<Fluj> records = (List<Fluj>) this.getAllLike(likes, search);

        return records;
    }
    
    public enum TypePayment{
        CASH,
        CARD_DEBIT,
        CARD_CREDIT,
        INITIAL_CASH
    }
}