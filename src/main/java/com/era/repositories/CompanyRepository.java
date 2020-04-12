/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.logger.LoggerUtility;
import com.era.models.Company;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 *
 * @author PC
 */
public class CompanyRepository extends Repository {
    
    protected CompanyRepository(){
        super(Company.class);
    }
    
    final public int saveOrUpdateCustomer(final Company Company) throws Exception {
        
        if(Company.getId()>0){
            
            this.update(Company);
            
            //Add log
            RepositoryFactory.getInstance().getLogRepository().addCustomerLog(Company.getCompanyCode());
        }
        else{
            
            this.save(Company);
            
            //Add log
            RepositoryFactory.getInstance().getLogRepository().addCustomerLog(Company.getCompanyCode());
            
            //Update the customer consecs
            RepositoryFactory.getInstance().getConsecsRepository().updateConsecCustomer(Company.getSer());
        }
        
        return Company.getId();
    }
    
    final public Company getCustomerByCode(final String companyCode) throws Exception {
        
        LoggerUtility.getSingleton().logInfo(CompanyRepository.class, "Hibernate: Getting customer by code " + companyCode);
                
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();        
        
        String hql = "FROM Company where companyCode = :companyCode";
        Query query = session.createQuery(hql);
        query.setParameter("companyCode", companyCode);
        Company Customer = query.list().size() > 0 ? (Company)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        LoggerUtility.getSingleton().logInfo(CompanyRepository.class, "Hibernate: Returning customer");
        
        //Return the result model
        return Customer;
    }
    
    final public Company getCustomerBySerieAndCode(final String serie,final String companyCode) throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();        
        
        String hql = "FROM Company where companyCode = :companyCode and serie = :serie";
        Query query = session.createQuery(hql);
        query.setParameter("serie", serie);
        query.setParameter("companyCode", companyCode);
        Company Company = query.list().size() > 0 ? (Company)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Company;
    }
    
    final public Company rfcExists(final String existRFC, final String rfcOri) throws Exception {
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();        
        
        String hql = "FROM Company where rfc = :existRFC and rfc != :rfcOri";
        Query query = session.createQuery(hql);
        query.setParameter("existRFC", existRFC);
        query.setParameter("rfcOri", rfcOri);
        Company Company = query.list().size() > 0 ? (Company)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Company;
    }
    
    final public void deleteByCodemp(final String codemp) throws Exception{
        
        //Open database
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();
        session.beginTransaction();
        
        //Save
        final SQLQuery SQLQuery = session.createSQLQuery("DELETE FROM Company WHERE codemp = :codemp");
        SQLQuery.setParameter("codemp", codemp);
        SQLQuery.executeUpdate();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
    }
    
    final public List<Company> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("nom");        
        likes.add("tel");
        likes.add("calle");
        likes.add("col");
        likes.add("cp");
        likes.add("ciu");
        likes.add("pais");
        likes.add("estad");
        likes.add("rfc");
        likes.add("co1");
        likes.add("co2");
        likes.add("co3");
        likes.add("pagweb1");
        likes.add("pagweb2");
        likes.add("pagweb2");
        likes.add("observ");
        
        final List<Company> customers = (List<Company>) this.getAllLike(likes, search);
        
        return customers;
    }
}