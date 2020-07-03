package com.era.repositories;

import com.era.logger.LoggerUtility;
import java.util.List;
import java.util.ArrayList;
import com.era.models.Cortszx;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;

public class CortszxsRepository extends Repository {

    public CortszxsRepository() {
        super(Cortszx.class);
    }

    final public int getNextCorteXZ(final Type Type_) throws Exception {
        
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
        final int consec = results.size()>0?(int)results.get(0):0;
        
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