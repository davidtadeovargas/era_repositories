package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Cortszx;
import com.era.repositories.utils.HibernateUtil;
import java.math.BigInteger;
import java.util.HashMap;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;

public class CortszxsRepository extends Repository {

    public CortszxsRepository() {
        super(Cortszx.class);
    }

    final public Cortszx updateNextCortX(final Cortszx Cortszx) throws Exception {        
        return this.updateNextCortXorZ(Cortszx,Type.X);
    }
    final public Cortszx updateNextCortZ(final Cortszx Cortszx) throws Exception {        
        return this.updateNextCortXorZ(Cortszx,Type.Z);
    }
    
    final public void updateAllAvailableCortsAsZNotAvailableAnyMore() throws Exception {
        
        HibernateUtil.getSingleton().openSessionInTransacction(ClassEntity);
        
        updateSQL("UPDATE Cortszx SET regis = true WHERE regis = false");
        
        //Update sales
        RepositoryFactory.getInstance().getSalessRepository().updateAllSalesAsCutS();
        
        HibernateUtil.getSingleton().closeSessionInTransaction(ClassEntity);
    }
    
    final public Cortszx updateNextCortXorZ(final Cortszx Cortszx, final Type Type_) throws Exception {
        
        final BigInteger nextConsec = this.getNextCorteXZ(Type_);
        
        String type = null;
        boolean regis = false;
        switch(Type_){

            case X:
                type = "x";
                regis = false;
                break;

            case Z:
                type = "z";
                regis = true;
                break;
        }
        
        Cortszx.setCort(type);
        Cortszx.setRegis(regis);
        
        //Update the next consec
        Cortszx.setNumcort(nextConsec.intValue());
        
        //Save or update
        this.save(Cortszx);        
        
        return Cortszx;
    }
    
    final public Cortszx getNextCorteXZObject(final Type Type_) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String type = "";
        switch(Type_){
            
            case X:
                type = "x";
                break;
            
            case Z:
                type = "z";
                break;
        }
        
        final String sqlQuery = "SELECT IFNULL(MAX(numcort),0) + 1 as numcort FROM cortszx WHERE cort = '" + type + "'";
        
        final SQLQuery SQLQuery = HibernateUtil.getSingleton().getSession().createSQLQuery(sqlQuery);
        SQLQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        final List results = SQLQuery.list();
        Cortszx Cortszx = SQLQuery.list().size() > 0 ? (Cortszx)SQLQuery.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        return Cortszx;
    }
    
    final public BigInteger getNextCorteXZ(final Type Type_) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String type = "";
        switch(Type_){
            
            case X:
                type = "x";
                break;
            
            case Z:
                type = "z";
                break;
        }
        
        final String sqlQuery = "SELECT IFNULL(MAX(numcort),0) + 1 as numcort FROM cortszx WHERE cort = '" + type + "'";
        
        final SQLQuery SQLQuery = HibernateUtil.getSingleton().getSession().createSQLQuery(sqlQuery);
        SQLQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        final List results = SQLQuery.list();
        final BigInteger consec = results.size()>0?(BigInteger)((HashMap)results.get(0)).get("numcort"):BigInteger.ZERO;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        return consec;
    }
    
    @Override
    final public List<Cortszx> getByLikeEncabezados(final String search) throws Exception{

        final List<String> likes = new ArrayList<>();
        likes.add("falt");
        likes.add("fmod");

        final List<Cortszx> records = (List<Cortszx>) this.getAllLike(likes, search);

        return records;
    }
    
    public enum Type{
        X,
        Z
    }
}