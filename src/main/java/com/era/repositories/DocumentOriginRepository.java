/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.repositories.utils.HibernateUtil;
import com.era.models.DocumentOrigin;
import com.era.logger.LoggerUtility;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class DocumentOriginRepository extends Repository {
    
    protected DocumentOriginRepository(){
        super(DocumentOrigin.class);
    }
    
    private DocumentOrigin getDocumentByType(final String type) throws Exception {
                        
        LoggerUtility.getSingleton().logInfo(DocumentOriginRepository.class, "Hibernate: Getting document origin by type " + type);
        
        //Open database
        this.openSession();
        
        String hql = "FROM DocumentOrigin where type = :type";
        Query query = session.createQuery(hql);
        query.setParameter("type", type);
        DocumentOrigin DocumentOrigin = query.list().size() > 0 ? (DocumentOrigin)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        LoggerUtility.getSingleton().logInfo(DocumentOriginRepository.class, "Hibernate: Returning document by type");
        
        //Return the response model
        return DocumentOrigin;
    }
        
    final public DocumentOrigin getDocumentOriginPREV() throws Exception {                        
        return getDocumentByType("PREV");
    }
    final public DocumentOrigin getDocumentOriginNOTC() throws Exception {                        
        return getDocumentByType("NOTC");
    }
    final public DocumentOrigin getDocumentOriginNOTP() throws Exception {                        
        return getDocumentByType("NOTP");
    }
    final public DocumentOrigin getDocumentOriginFAC() throws Exception {                        
        return getDocumentByType("FAC");
    }
    final public DocumentOrigin getDocumentOriginTIK() throws Exception {                        
        return getDocumentByType("TIK");
    }
    final public DocumentOrigin getDocumentOriginCOT() throws Exception {
        return getDocumentByType("COT");
    }
    final public DocumentOrigin getDocumentOriginEMP() throws Exception {
        return getDocumentByType("EMP");
    }
    final public DocumentOrigin getDocumentOriginPROV() throws Exception {
        return getDocumentByType("PROV");
    }
    final public DocumentOrigin getDocumentOriginREM() throws Exception {
        return getDocumentByType("REM");
    }
    final public DocumentOrigin getDocumentOriginCOMP() throws Exception {
        return getDocumentByType("COMP");
    }
    final public DocumentOrigin getDocumentOriginORDC() throws Exception {
        return getDocumentByType("ORDC");
    }
    final public DocumentOrigin getDocumentOriginPAG() throws Exception {
        return getDocumentByType("PAG");
    }
    final public DocumentOrigin getDocumentOriginPED() throws Exception {
        return getDocumentByType("PED");
    }
}
