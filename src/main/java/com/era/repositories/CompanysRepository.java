package com.era.repositories;

import com.era.logger.LoggerUtility;
import com.era.models.Company;
import com.era.repositories.utils.HibernateUtil;
import com.era.utilities.UtilitiesFactory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class CompanysRepository extends Repository {

   public CompanysRepository() {
        super(Company.class);
    }
   
   final public int saveOrUpdateCustomer(final Company Company) throws Exception {
        
        if(Company.getId()>0){
            
            this.update(Company);
            
            //Add log
            RepositoryFactory.getInstance().getLogsRepository().addCustomerLog(Company.getCompanyCode());
        }
        else{
            
            this.save(Company);
            
            //Add log
            RepositoryFactory.getInstance().getLogsRepository().addCustomerLog(Company.getCompanyCode());
        }
        
        return Company.getId();
    }
   
   public String getCustomerConditions(final Company Company) throws Exception {
        
        //If the user has credit
        String conditions;        
        if(Company.hasCredit()){
            conditions = props.getProperty("customer_credit_at_days");                        
            conditions = conditions.replace("%1",String.valueOf(Company.getDiacred()));
            conditions = conditions.replace("%2",UtilitiesFactory.getSingleton().getNumbersUtility().toMoneyFormat(String.valueOf(Company.getLimtcred())));
        }
        else{                        
            conditions = props.getProperty("pay_at_moment");
        }                
        
        //Get positive sald of the customer
        final BigDecimal favorSald = RepositoryFactory.getInstance().getCxcRepository().getSaldoFavorFromCustomer(Company.getCompanyCode());
        
        //Concatenate the sald
        conditions = conditions.replace("%3",String.valueOf(favorSald));
        
        return conditions;
    }
   
    final public Company getClienteMostrador() throws Exception {        
        return this.getCustomerByCode("EMPMOS");
    }
   
    final public Company getCustomerByCode(final String companyCode) throws Exception {
        
        LoggerUtility.getSingleton().logInfo(CompanysRepository.class, "Hibernate: Getting customer by code " + companyCode);
                
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Company where companyCode = :companyCode";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("companyCode", companyCode);
        Company Customer = query.list().size() > 0 ? (Company)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        LoggerUtility.getSingleton().logInfo(CompanysRepository.class, "Hibernate: Returning customer");
        
        //Return the result model
        return Customer;
    }
    
    final public Company getCustomerBySerieAndCode(final String serie,final String companyCode) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Company where companyCode = :companyCode and serie = :serie";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("serie", serie);
        query.setParameter("companyCode", companyCode);
        Company Company = query.list().size() > 0 ? (Company)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Company;
    }
    
    final public Company rfcExists(final String existRFC, final String rfcOri) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Company where rfc = :existRFC and rfc != :rfcOri";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("existRFC", existRFC);
        query.setParameter("rfcOri", rfcOri);
        Company Company = query.list().size() > 0 ? (Company)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Company;
    }
    
    final public Company rfcExists(final String RFC) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Company where rfc = :RFC";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("RFC", RFC);        
        Company Company = query.list().size() > 0 ? (Company)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Company;
    }
    
    final public void deleteByCodemp(final String codemp) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        //Save
        final SQLQuery SQLQuery = HibernateUtil.getSingleton().getSession().createSQLQuery("DELETE FROM Company WHERE codemp = :codemp");
        SQLQuery.setParameter("codemp", codemp);
        SQLQuery.executeUpdate();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
    }
    
   @Override
    final public List<Company> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("nom");        
        likes.add("tel");
        likes.add("calle");
        likes.add("col");
        likes.add("cp");
        likes.add("ciu");
        likes.add("pai");
        likes.add("estad");
        likes.add("rfc");
        likes.add("co1");
        likes.add("co2");
        likes.add("pagweb1");
        likes.add("observ");
        
        final List<Company> customers = (List<Company>) this.getAllLike(likes, search);
        
        return customers;
    }
}