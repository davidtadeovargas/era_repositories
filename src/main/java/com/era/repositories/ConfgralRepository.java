/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Confgral;
import com.era.repositories.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 *
 * @author PC
 */
public class ConfgralRepository extends Repository {

    public ConfgralRepository() {
        super(Confgral.class);
    }
    
    final public void activeInvConfig(final String clasif) throws Exception{
        activeConfig("inv",clasif);
    }
    final public void disableInvConfig(final String clasif) throws Exception{
        inverseConfig("inv",clasif);
    }
    public void setTrasnfersOnlyWithExistencies(final boolean value) throws Exception{
        if(value){
            activeInvConfig("traspasexis");
        }
        else{
            disableInvConfig("traspasexis");
        }        
    }
    public Confgral getTrasnfersOnlyWithExistencies() throws Exception{
        return getInvClasifByConf("traspasexis");        
    }
    public void setProductsWithEqualsSerie(final boolean value) throws Exception{
        if(value){
            activeInvConfig("igualser");
        }
        else{
            disableInvConfig("igualser");
        }
    }
    public Confgral getProductsWithEqualsSerie() throws Exception{
        return getInvClasifByConf("igualser");        
    }
    public void setOutputOfInventWithExistences(final boolean value) throws Exception{
        if(value){
            activeInvConfig("esexitmov");
        }
        else{
            disableInvConfig("esexitmov");
        }        
    }
    public Confgral getOutputOfInventWithExistences() throws Exception{
        return getInvClasifByConf("esexitmov");        
    }
    
    
    
    
    final public void activePrevCompConfig(final String clasif) throws Exception{
        activeConfig("prev",clasif);
    }
    final public void disablePrevCompConfig(final String clasif) throws Exception{
        inverseConfig("prev",clasif);
    }
    public void setOnlyNationalCointInPrevComps(final boolean value) throws Exception{
        if(value){
            activePrevCompConfig("prevmonac");
        }
        else{
            disablePrevCompConfig("prevmonac");
        }        
    }
    public Confgral getOnlyNationalCointInPrevComps() throws Exception{
        return getPrevClasifByConf("prevmonac");        
    }
    
    
    
    
    
    
    
    final public void activeVtasConfig(final String conf) throws Exception{
        activeConfig("vtas",conf);
    }
    final public void disableVtasConfig(final String clasif) throws Exception{
        inverseConfig("vtas",clasif);
    }
    final public void activeVtasExtraConfig(final String conf, final String extra) throws Exception{
        activeExtraConfig("vtas",conf,extra);
    }
    final public void activeVtasNumeConfig(final String clasif, final double nume) throws Exception{
        activeNumeConfig("vtas",clasif,nume);
    }    
    public void setApplyPriceListOfCustomersInInvoice(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("alistpreclifac");
        }
        else{
            disableVtasConfig("alistpreclifac");
        }        
    }
    public Confgral getApplyPriceListOfCustomersInInvoice() throws Exception{
        return getSalesClasifByConf("alistpreclifac");        
    }
    public void setShowMessageIfNotExistencesInInvoice(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("msjexistnegfac");
        }
        else{
            disableVtasConfig("msjexistnegfac");
        }        
    }
    public Confgral getShowMessageIfNotExistencesInInvoice() throws Exception{
        return getSalesClasifByConf("msjexistnegfac");        
    }
    public void setSaleWithoutExistencesInInvoice(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("vendsinexistfac");
        }
        else{
            disableVtasConfig("vendsinexistfac");
        }        
    }
    public Confgral getSaleWithoutExistencesInInvoice() throws Exception{
        return getSalesClasifByConf("vendsinexistfac");        
    }
    public void setSaleOverlimitCreditInInvoice(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("slimcredfac");
        }
        else{
            disableVtasConfig("slimcredfac");
        }
    }
    public Confgral getSaleOverlimitCreditInInvoice() throws Exception{
        return getSalesClasifByConf("slimcredfac");        
    }
    public void setSaleJustInNationalCoin(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("otramon");
        }
        else{
            disableVtasConfig("otramon");
        }        
    }
    public Confgral getSaleJustInNationalCoin() throws Exception{
        return getSalesClasifByConf("otramon");        
    }
    public void setCanCancelInvoicesInSalespoint(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("canfacpto");
        }
        else{
            disableVtasConfig("canfacpto");
        }
    }
    public Confgral getCanCancelInvoicesInSalespoint() throws Exception{
        return getSalesClasifByConf("canfacpto");        
    }
    public void setApplyCustomerPriceInSalespoint(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("alistpreclipvta");
        }
        else{
            disableVtasConfig("alistpreclipvta");
        }
    }
    public Confgral getApplyCustomerPriceInSalespoint() throws Exception{
        return getSalesClasifByConf("alistpreclipvta");        
    }
    public void setShowMessageWithNoExistencesInSalespoint(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("msjexistnegpvta");
        }
        else{
            disableVtasConfig("msjexistnegpvta");
        }
    }
    public Confgral getShowMessageWithNoExistencesInSalespoint() throws Exception{
        return getSalesClasifByConf("msjexistnegpvta");        
    }
    public void setSaleWithNoExistencesInSalespoint(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("vendsinexistpvta");
        }
        else{
            disableVtasConfig("vendsinexistpvta");
        }
    }
    public Confgral getSaleWithNoExistencesInSalespoint() throws Exception{
        return getSalesClasifByConf("vendsinexistpvta");        
    }
    public void setShowProductsPanelInSalespoint(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("barlat");
        }
        else{
            disableVtasConfig("barlat");
        }        
    }
    public Confgral getShowProductsPanelInSalespoint() throws Exception{
        return getSalesClasifByConf("barlat");        
    }
    public void setShowProductsImagesInPanelInSalespoint(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("imglin");
        }
        else{
            disableVtasConfig("imglin");
        }
    }
    public Confgral getShowProductsImagesInPanelInSalespoint() throws Exception{
        return getSalesClasifByConf("imglin");        
    }
    public void setInitSalesPointOnIinitSystem(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("initpvta");
        }
        else{
            disableVtasConfig("initpvta");
        }        
    }
    public Confgral getInitSalesPointOnIinitSystem() throws Exception{
        return getSalesClasifByConf("initpvta");        
    }
    public void setSaleOverCreditLimitOnPointOfSales(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("slimcredpvta");
        }
        else{
            disableVtasConfig("slimcredpvta");
        }
    }
    public Confgral getSaleOverCreditLimitOnPointOfSales() throws Exception{
        return getSalesClasifByConf("slimcredpvta");        
    }
    public void setNewCustomersOnPointOfSales(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("empspto");
        }
        else{
            disableVtasConfig("empspto");
        }
    }
    public Confgral getNewCustomersOnPointOfSales() throws Exception{
        return getSalesClasifByConf("empspto");        
    }
    public void setAskForAdminPasswordOnCancelInvoicesOnPointOfSales(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("admcanvtas");
        }
        else{
            disableVtasConfig("admcanvtas");
        }
    }
    public Confgral getAskForAdminPasswordOnCancelInvoicesOnPointOfSales() throws Exception{
        return getSalesClasifByConf("admcanvtas");        
    }
    public void setReturnSalesOnPointOfSales(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("devvtaspto");
        }
        else{
            disableVtasConfig("devvtaspto");
        }        
    }
    public Confgral getReturnSalesOnPointOfSales() throws Exception{
        return getSalesClasifByConf("devvtaspto");        
    }
    public void setPartialReturnsOfSalesOnPointOfSales(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("devpvtaspto");
        }
        else{
            disableVtasConfig("devpvtaspto");
        }
    }
    public Confgral getPartialReturnsOfSalesOnPointOfSales() throws Exception{
        return getSalesClasifByConf("devpvtaspto");        
    }
    public void setSaleOverLimitCreditInRemisions(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("slimcredrem");
        }
        else{
            disableVtasConfig("slimcredrem");
        }
    }
    public Confgral getSaleOverLimitCreditInRemisions() throws Exception{
        return getSalesClasifByConf("slimcredrem");        
    }
    public void setCanCancelOrReturnRemisionsInPointOfSales(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("canrempto");
        }
        else{
            disableVtasConfig("canrempto");
        }
    }
    public Confgral getCanCancelOrReturnRemisionsInPointOfSales() throws Exception{
        return getSalesClasifByConf("canrempto");        
    }
    public void setCanCancelOrReturnTicketsInPointOfSales(final boolean value) throws Exception{
        if(value){
            activeVtasConfig("canticpto");
        }
        else{
            disableVtasConfig("canticpto");
        }
    }
    public Confgral getCanCancelOrReturnTicketsInPointOfSales() throws Exception{
        return getSalesClasifByConf("canticpto");        
    }
    public void setMinAmmountToInvoice(final double nume) throws Exception{
        activeVtasNumeConfig("minfac",nume);
        
    }
    public Confgral getMinAmmountToInvoice() throws Exception{
        return getSalesClasifByConf("minfac");        
    }
    public void setWarehouseForSalesOnPointOfSales(final String extra) throws Exception{
        activeVtasExtraConfig("almavtaf",extra);
    }
    public Confgral getWarehouseForSalesOnPointOfSales() throws Exception{
        return getSalesClasifByConf("almavtaf");        
    }
    public void setSerieInvoiceRemain(final String extra) throws Exception{
        activeVtasExtraConfig("serfacfij",extra);
    }
    public Confgral getSerieInvoiceRemain() throws Exception{
        return getSalesClasifByConf("serfacfij");
    }
    public void setSerieInvoiceInPointOfSale(final String extra) throws Exception{
        activeVtasExtraConfig("serfac",extra);
    }
    public Confgral getSerieInvoiceInPointOfSale() throws Exception{
        return getSalesClasifByConf("serfac");
    }
    public void setSerieTickInPointOfSale(final String extra) throws Exception{
        activeVtasExtraConfig("sertic",extra);
    }
    public Confgral getSerieTickInPointOfSale() throws Exception{
        return getSalesClasifByConf("sertic");
    }
    public void setSerieRemisionsInPointOfSale(final String extra) throws Exception{
        activeVtasExtraConfig("serrem",extra);
    }
    public Confgral getSerieRemisionsInPointOfSale() throws Exception{
        return getSalesClasifByConf("serrem");
    }
    
    
    
    
    final public void activeCotsConfig(final String clasif) throws Exception{
        activeConfig("cots",clasif);
    }
    final public void disableCotsConfig(final String clasif) throws Exception{
        inverseConfig("cots",clasif);
    }
    public void setShowMesageWhenNoExistencesInCots(final boolean value) throws Exception{
        if(value){
            activeCotsConfig("msjexistnegpcot");
        }
        else{
            disableCotsConfig("msjexistnegpcot");
        }
    }
    public Confgral getShowMesageWhenNoExistencesInCots() throws Exception{
        return getCotsClasifByConf("msjexistnegpcot");        
    }
    public void setSaleWithoutExistencesInCots(final boolean value) throws Exception{
        if(value){
            activeCotsConfig("vendsinexistcot");
        }
        else{
            disableCotsConfig("vendsinexistcot");
        }
    }
    public Confgral getSaleWithoutExistencesInCots() throws Exception{
        return getCotsClasifByConf("vendsinexistcot");        
    }
    public void setSaleOnlyInNationalCoinInCots(final boolean value) throws Exception{
        if(value){
            activeCotsConfig("otramon");
        }
        else{
            disableCotsConfig("otramon");
        }
    }
    public Confgral getSaleOnlyInNationalCoinInCots() throws Exception{
        return getCotsClasifByConf("otramon");        
    }
    
    
    
    final public void activeSistConfig(final String clasif) throws Exception{
        activeConfig("sist",clasif);
    }
    final public void disableSistConfig(final String clasif) throws Exception{
        inverseConfig("sist",clasif);
    }
    final public void activeSistExtraConfig(final String conf, final String extra) throws Exception{
        activeExtraConfig("sist",conf,extra);
    }
    final public void activeSistNumeConfig(final String clasif, final double nume) throws Exception{
        activeNumeConfig("sist",clasif,nume);
    }
    public void setSuspendInInactvity(final boolean value) throws Exception{
        if(value){
            activeSistConfig("dlogin");
        }
        else{
            disableSistConfig("dlogin");
        }
    }
    public Confgral getSuspendInInactvity() throws Exception{
        return getSistClasifByConf("dlogin");        
    }
    public void setDecimals(final double nume) throws Exception{
        activeSistNumeConfig("posdecimal",nume);
    }
    public Confgral getDecimals() throws Exception{
        return getSistClasifByConf("posdecimal");        
    }
    
    
    
    
    
    
    final public void activeCompConfig(final String clasif) throws Exception{
        activeConfig("comps",clasif);
    }
    final public void disableCompConfig(final String clasif) throws Exception{
        inverseConfig("comps",clasif);
    }
    final public void activeCompExtraConfig(final String conf, final String extra) throws Exception{
        activeExtraConfig("comps",conf,extra);
    }
    public void setBuyOnlyInNationalCoin(final boolean value) throws Exception{
        if(value){
            activeSistConfig("otramon");
        }
        else{
            disableSistConfig("otramon");
        }
    }
    public Confgral getBuyOnlyInNationalCoin() throws Exception{
        return getCompsClasifByConf("otramon");        
    }
    
    final public void disableAllConfigs() throws Exception{
        this.updateSQL("UPDATE Confgral SET val = 0");
    }
    
    final public Confgral getSistemClasifByConf(final String conf) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Confgral where clasif = 'sist' AND conf = :conf";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("conf", conf);
        Confgral Confgral = query.list().size() > 0 ? (Confgral)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Confgral;
    }
    
    final public Confgral getSalesClasifByConf(final String conf) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Confgral where clasif = 'vtas' AND conf = :conf";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("conf", conf);
        Confgral Confgral = query.list().size() > 0 ? (Confgral)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Confgral;
    }
    
    final public Confgral getCotsClasifByConf(final String conf) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Confgral where clasif = 'cots' AND conf = :conf";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("conf", conf);
        Confgral Confgral = query.list().size() > 0 ? (Confgral)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Confgral;
    }
    
    final public Confgral getSistClasifByConf(final String conf) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Confgral where clasif = 'sist' AND conf = :conf";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("conf", conf);
        Confgral Confgral = query.list().size() > 0 ? (Confgral)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Confgral;
    }
    
    final public Confgral getCompsClasifByConf(final String conf) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Confgral where clasif = 'comps' AND conf = :conf";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("conf", conf);
        Confgral Confgral = query.list().size() > 0 ? (Confgral)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Confgral;
    }
    
    final public Confgral getInvClasifByConf(final String conf) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Confgral where clasif = 'inv' AND conf = :conf";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("conf", conf);
        Confgral Confgral = query.list().size() > 0 ? (Confgral)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Confgral;
    }
    
    final public Confgral getPrevClasifByConf(final String conf) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Confgral where clasif = 'prev' AND conf = :conf";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("conf", conf);
        Confgral Confgral = query.list().size() > 0 ? (Confgral)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Confgral;
    }
    
    final public String getPtovtaAlmacen() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Confgral where clasif = 'vtas' AND conf = :conf";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("conf", "almapto");
        Confgral Confgral = query.list().size() > 0 ? (Confgral)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        final String almacen = Confgral==null?null:Confgral.getExtr();
        
        return almacen;
    }
    
    final public Confgral getByClasif(final String clasif) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Confgral where clasif = :clasif";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("clasif", clasif);
        Confgral Confgral = query.list().size() > 0 ? (Confgral)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Confgral;
    }
    
    
    final public Confgral getByConfigPostdecimal() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Confgral where clasif = :clasif AND conf = :conf";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("clasif", "sist");
        query.setParameter("conf", "posdecimal");
        Confgral Confgral = query.list().size() > 0 ? (Confgral)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Confgral;
    }
    
    final public boolean initWithSalesPointWindow() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Confgral where clasif = :clasif AND conf = :conf";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("clasif", "vtas");
        query.setParameter("conf", "initpvta");
        Confgral Confgral = query.list().size() > 0 ? (Confgral)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Confgral!=null?Confgral.getVal()==1:false;
    }
    
    final public List<Confgral> getAllActivesByClasif(final String clasif) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Confgral where clasif = :clasif AND val = 1";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("clasif", clasif);
        List<Confgral> list = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return list;
    }
    
    final public List<Confgral> getAllActivesByConf(final String clasif) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Confgral where clasif = :clasif";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("clasif", clasif);
        List<Confgral> list = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return list;
    }
    
    final public List<Confgral> getAllActivesConfs() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM Confgral where val = :val";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("val", 1);
        List<Confgral> list = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return list;
    }
    
    final public void activeConfig(final String clasif, final String conf) throws Exception{
        this.updateSQL("UPDATE confgral SET val = 1 WHERE conf = \"" + conf + "\" AND clasif = \"" + clasif + "\"");
    }
    final public void inverseConfig(final String clasif, final String conf) throws Exception{
        this.updateSQL("UPDATE confgral SET val = 0 WHERE conf = \"" + conf + "\" AND clasif = \"" + clasif + "\"");
    }
    final public void activeExtraConfig(final String clasif, final String conf, final String extra) throws Exception{
        this.updateSQL("UPDATE confgral SET extr = \"" + extra + "\" WHERE conf = \"" + conf + "\" AND clasif = \"" + clasif + "\"");
    }
    final public void activeNumeConfig(final String clasif, final String conf, final double nume) throws Exception{
        this.updateSQL("UPDATE confgral SET nume = " + nume + " WHERE conf = \"" + conf + "\" AND clasif = \"" + clasif + "\"");
    }
    
    final public void deleteByConfg(final String conf) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        //Save
        final SQLQuery SQLQuery = HibernateUtil.getSingleton().getSession().createSQLQuery("DELETE FROM confgral WHERE conf = :conf");
        SQLQuery.setParameter("conf", conf);
        SQLQuery.executeUpdate();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
    }
    
    @Override
    final public List<Confgral> getByLikeEncabezados(final String search) throws Exception{
        return null;        
    }
}