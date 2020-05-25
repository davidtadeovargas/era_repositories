/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.repositories.utils.HibernateUtil;
import com.era.logger.LoggerUtility;
import com.era.models.Serie;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author PC
 */
public class SerieRepository extends Repository {
    
    protected SerieRepository(){
        super(Serie.class);
    }
    
    final public Serie getFirstSerieByType(final String type) throws Exception {
                
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Getting first serie NOTC");
                
        //Open database        
        HibernateUtil.getSingleton().openSession(ClassEntity);
                
        Criteria c = HibernateUtil.getSingleton().getSession().createCriteria(Serie.class);
        c.addOrder(Order.asc("id"));
        c.add(Restrictions.eq("type",type));        
        c.setMaxResults(1);
        Serie Serie = (Serie)c.uniqueResult();
        
        //Close database                
        HibernateUtil.getSingleton().closeSession();
        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Returning first serie NOTC " + Serie);
        
        //Return the response model
        return Serie;
    }
    
    final public List<Serie> getAllByType(final String type) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Serie where type = :type";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("type", type);
        List<Serie> Series = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession();
        
        //Return the response model
        return Series;
    }
    
    final public List<Serie> getAllSeriePREV() throws Exception {
        return getAllByType("PREV");
    }
    final public List<Serie> getAllSerieNOTC() throws Exception {
        return getAllByType("NOTC");
    }
    final public List<Serie> getAllSerieNOTP() throws Exception {
        return getAllByType("NOTP");
    }
    final public List<Serie> getAllSerieFAC() throws Exception {
        return getAllByType("FAC");
    }
    final public List<Serie> getAllSerieTIK() throws Exception {
        return getAllByType("TIK");
    }
    final public List<Serie> getAllSerieCOT() throws Exception {
        return getAllByType("COT");
    }
    final public List<Serie> getAllSerieEMP() throws Exception {
        return getAllByType("EMP");
    }
    final public List<Serie> getAllSeriePROV() throws Exception {
        return getAllByType("PROV");
    }
    final public List<Serie> getAllSerieREM() throws Exception {
        return getAllByType("REM");
    }
    final public List<Serie> getAllSerieCOMP() throws Exception {
        return getAllByType("COMP");
    }
    final public List<Serie> getAllSerieORDC() throws Exception {
        return getAllByType("ORDC");
    }
    final public List<Serie> getAllSerieCXC() throws Exception {
        return getAllByType("CXC");
    }
    final public List<Serie> getAllSeriePED() throws Exception {
        return getAllByType("PED");
    }
    
    final public Serie getFirstSeriePREV() throws Exception {
        return getFirstSerieByType("PREV");
    }
    final public Serie getFirstSerieNOTC() throws Exception {
        return getFirstSerieByType("NOTC");
    }
    final public Serie getFirstSerieNOTP() throws Exception {
        return getFirstSerieByType("NOTP");
    }
    final public Serie getFirstSerieFAC() throws Exception {
        return getFirstSerieByType("FAC");
    }
    final public Serie getFirstSerieTIK() throws Exception {
        return getFirstSerieByType("TIK");
    }
    final public Serie getFirstSerieCOT() throws Exception {
        return getFirstSerieByType("COT");
    }
    final public Serie getFirstSerieEMP() throws Exception {
        return getFirstSerieByType("EMP");
    }
    final public Serie getFirstSeriePROV() throws Exception {
        return getFirstSerieByType("PROV");
    }
    final public Serie getFirstSerieREM() throws Exception {
        return getFirstSerieByType("REM");
    }
    final public Serie getFirstSerieCOMP() throws Exception {
        return getFirstSerieByType("COMP");
    }
    final public Serie getFirstSerieORDC() throws Exception {
        return getFirstSerieByType("ORDC");
    }
    final public Serie getFirstSerieCXC() throws Exception {
        return getFirstSerieByType("CXC");
    }
    final public Serie getFirstSeriePEDIDOS() throws Exception {
        return getFirstSerieByType("PED");
    }
    
    final public void addSerieTypePREV(final Serie Serie) throws Exception {
                
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Adding serie PREV");                
        Serie.setType("PREV");
        save(Serie);        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Serie type PREV added");
    }
    
    final public void addSerieTypeNOTC(final Serie Serie) throws Exception {
                
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Adding serie NOTC");                
        Serie.setType("NOTC");
        save(Serie);        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Serie type NOTC added");
    }
    
    final public void addSerieTypeNOTP(final Serie Serie) throws Exception {
                
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Adding serie NOTP");                
        Serie.setType("NOTP");
        save(Serie);        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Serie type NOTP added");
    }
    
    final public void addSerieTypeFAC(final Serie Serie) throws Exception {
                
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Adding serie FAC");                
        Serie.setType("FAC");
        save(Serie);        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Serie type FAC added");
    }
    
    final public void addSerieTypeTIK(final Serie Serie) throws Exception {
                
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Adding serie TIK");                
        Serie.setType("TIK");
        save(Serie);        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Serie type TIK added");
    }
    
    final public void addSerieTypeCOT(final Serie Serie) throws Exception {
                
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Adding serie COT");                
        Serie.setType("COT");
        save(Serie);        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Serie type COT added");
    }
    
    final public void addSerieTypeEMP(final Serie Serie) throws Exception {
                
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Adding serie EMP");                
        Serie.setType("EMP");
        save(Serie);        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Serie type EMP added");
    }
    
    final public void addSerieTypePROV(final Serie Serie) throws Exception {
                
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Adding serie PROV");                
        Serie.setType("PROV");
        save(Serie);        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Serie type PROV added");
    }
    
    final public void addSerieTypeREM(final Serie Serie) throws Exception {
                
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Adding serie REM");                
        Serie.setType("REM");
        save(Serie);        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Serie type REM added");
    }
    
    final public void addSerieTypeCOMP(final Serie Serie) throws Exception {
                
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Adding serie COMP");                
        Serie.setType("COMP");
        save(Serie);        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Serie type COMP added");
    }
    
    final public void addSerieTypeORDC(final Serie Serie) throws Exception {
                
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Adding serie ORDC");                
        Serie.setType("ORDC");
        save(Serie);        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Serie type ORDC added");
    }
    
    final public void addSerieTypeCXC(final Serie Serie) throws Exception {
                
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Adding serie CXC");                
        Serie.setType("CXC");
        save(Serie);        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Serie type CXC added");
    }
    
    final public void addSerieTypePEDIDOS(final Serie Serie) throws Exception {
                
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Adding serie PEDIDOS");                
        Serie.setType("PEDIDOS");
        save(Serie);        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Serie type PEDIDOS added");
    }
    
    final public int updateSerie(final Serie Serie) throws Exception {
                
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: updating serie");
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Serie: " + Serie);
        
        //Update the consecutive
        Serie.setConsecutive(Serie.getConsecutive() + 1);
        
        //Update the record
        save(Serie);
        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Serie updated");                
        
        return Serie.getId();
    }
    
    public Serie getBySerie(final String serie) throws Exception {
                        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Getting serie by serie: " + serie);
                
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        HibernateUtil.getSingleton().getSession().beginTransaction();
        
        String hql = "FROM Serie where serie = :serie";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("serie", serie);
        Serie Serie = query.list().size() > 0 ? (Serie)query.list().get(0):null;
        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Returning serie " + Serie);
        
        //Return the response model
        return Serie;
    }
    
    public Serie getSerieByType(final String type) throws Exception {
                        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Getting serie by type: " + type);
                
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        HibernateUtil.getSingleton().getSession().beginTransaction();
        
        String hql = "FROM Serie where type = :type";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("type", type);
        Serie Serie = query.list().size() > 0 ? (Serie)query.list().get(0):null;
        
        LoggerUtility.getSingleton().logInfo(SerieRepository.class, "Hibernate: Returning serie by type: " + type);
        
        //Return the response model
        return Serie;
    }
    
    final public Serie getSeriePreviusComp() throws Exception {
        return getSerieByType("PREV");
    }
    
    final public Serie getSerieNoteCredit() throws Exception {
        return getSerieByType("NOTC");
    }
    
    final public Serie getSerieNoteProvider() throws Exception {
        return getSerieByType("NOTP");
    }
    
    final public Serie getSerieFAC() throws Exception {
        return getSerieByType("FAC");
    }
    
    final public Serie getSerieNotCred() throws Exception {
        return getSerieByType("TIK");
    }
    
    final public Serie getSerieCots() throws Exception {
        return getSerieByType("COT");
    }
    
    final public Serie getSerieCustomers() throws Exception {
        return getSerieByType("EMP");
    }
    
    final public Serie getSerieProviders() throws Exception {
        return getSerieByType("PROV");
    }
    
    final public Serie getSerieRemission() throws Exception {
        return getSerieByType("REM");
    }
    
    final public Serie getSeriePurchases() throws Exception {
        return getSerieByType("COMP");
    }
    
    final public Serie getSerieCreditOrder() throws Exception {
        return getSerieByType("ORDC");
    }
    
    final public Serie getSerieCXC() throws Exception {
        return getSerieByType("CXC");
    }
    
    final public Serie getSerieOrders() throws Exception {
        return getSerieByType("PEDIDOS");
    }
}
