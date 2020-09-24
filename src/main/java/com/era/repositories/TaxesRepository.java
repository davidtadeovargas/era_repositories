/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Tax;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;

/**
 *
 * @author PC
 */
public class TaxesRepository extends Repository {
    
    protected TaxesRepository(){
        super(Tax.class);
    }

    final public void saveOrUpdate(final Tax Tax) throws Exception{
        
        final Tax Tax_ = (Tax)this.getByCode(Tax.getCode());
        if(Tax_!=null){
            Tax_.setValue(Tax.getValue());
            this.update(Tax_);
        }
        else{
            this.save(Tax);
        }
    }
    
    final public void deleteByCodimpue(final String codimpue) throws Exception{
        
        //Open database
        openDatabase();
        
        //Save
        final SQLQuery SQLQuery = HibernateUtil.getSingleton().getSession().createSQLQuery("DELETE FROM Tax WHERE codimpue = :codimpue");
        SQLQuery.setParameter("codimpue", codimpue);
        SQLQuery.executeUpdate();
        
        //Close database        
        closeDatabase();
    }
    
    @Override
    final public List<Tax> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("codimpue");
        likes.add("impueval");
        likes.add("falt");
        likes.add("fmod");
        
        final List<Tax> taxes = (List<Tax>) this.getAllLike(likes, search);
        
        return taxes;
    }
}