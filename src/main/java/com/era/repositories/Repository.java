/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.logger.LoggerUtility;
import com.era.models.Aduana;
import com.era.models.Anaqs;
import com.era.models.Banco;
import com.era.models.BasDats;
import com.era.models.Clasificacion;
import com.era.models.Coin;
import com.era.models.Compa;
import com.era.models.ServerSession;
import com.era.models.Company;
import com.era.models.Comprs;
import com.era.models.License;
import com.era.models.Concepnot;
import com.era.models.Conceppag;
import com.era.models.Conceps;
import com.era.models.Fabs;
import com.era.models.Giro;
import com.era.models.ImpuesXProduct;
import com.era.models.Kits;
import com.era.models.Line;
import com.era.models.Log;
import com.era.models.Lugs;
import com.era.models.Marcs;
import com.era.models.Measure;
import com.era.models.Meds;
import com.era.models.MetogoPago;
import com.era.models.Ords;
import com.era.models.Payment;
import com.era.models.Pedidos;
import com.era.models.Pes;
import com.era.models.Product;
import com.era.models.Responsable;
import com.era.models.Rubr;
import com.era.models.Sales;
import com.era.models.Sectores;
import com.era.models.Subramos;
import com.era.models.Sucursal;
import com.era.models.Supplier;
import com.era.models.Tax;
import com.era.models.Tipactfij;
import com.era.models.Tips;
import com.era.models.Unid;
import com.era.models.User;
import com.era.models.Warehouse;
import com.era.models.Zona;
import com.era.repositories.utils.HibernateUtil;
import com.era.utilities.UtilitiesFactory;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.classic.Session;

/**
 *
 * @author PC
 */
public abstract class Repository {
    
    protected final Class ClassEntity;
    protected final int paginationSize = 50;
    
    
    
    public abstract List<?> getByLikeEncabezados(final String search) throws Exception;
    
    protected Repository(final Class ClassEntity){
        
        this.ClassEntity = ClassEntity;
    }

    public int getPaginationSize() {
        return paginationSize;
    }
        
    
    public List<?> getAllByPage(final int pageNumber) throws Exception {
        final List<?> records = this.getAllByPage(pageNumber,paginationSize);
        return records;
    }
    
    public List<?> getAllByPage(final int pageNumber, int pageSize) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);       
        
        final Session Session = HibernateUtil.getSingleton().getSession();
        
        String hql = "FROM " + ClassEntity.getName();
        Query query = Session.createQuery(hql);
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        List<?> records = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return records;
    }
    
    final public long getCount() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "select count(*) from " + ClassEntity.getName();        
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);        
        Iterator count = query.iterate();
        
        //Return the result model
        long val;
        if(count.hasNext()){
            val = (long) count.next();
        }
        else{
            val = 0;
        }
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        return val;
    }
    
    final public Object getByID(final int id) throws Exception {
                        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Geting by id " + id + " from " + ClassEntity.getName());
        
        final Object Object = HibernateUtil.getSingleton().getSession().get(ClassEntity, id);
                
        LoggerUtility.getSingleton().logInfo(Repository.class, "Finished getting by id");
        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the response model
        return Object;
    }
    
    final public List<?> getAll() throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Geting all objects from " + ClassEntity.getName());
        
        String hql = "FROM " + ClassEntity.getName();
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);        
        List<?> list = query.list();
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Finished geting all objects ");
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return list;
    }
        
    final public List<?> getAllLike(final List<String> likes, final String search) throws Exception{
    
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
             
        //Get results
        String cad;
        if(likes.isEmpty()){
            cad = "";
        }
        else{
            
            cad = "WHERE ";
            for(String like:likes){
                cad += like + " LIKE:" + like + " OR ";
            }
            if(cad.endsWith(" OR ")){
                cad = cad.substring(0, cad.length() - " OR ".length());
            }
        }
        String hql = "FROM " + ClassEntity.getName() + " " + cad;
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        if(!cad.isEmpty()){
            for(String like:likes){
                query.setString(like,"%" + search + "%");
            }
        }
        List<?> list = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return list;
    }
    
    final public Object getByNoRefer(final String norefer) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM " + ClassEntity.getName() + " WHERE norefer = :norefer";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);    
        query.setParameter("norefer", norefer);
        Object Object = query.list().size()>0?query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Object;
    }
    
    final public Object deleteById(final int id) throws Exception {
        
        //Get the license
        final Object Object = this.getByID(id); 
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Deleting by id " + id);
        
        insertLog(Object,"delete",null);
        
        //Delete the license
        if(Object!=null){
            delete(Object);
        }            
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Finished deleting by id ");
        
        return Object;
    }
    
    final public void deleteAll() throws Exception {
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Deleting all Objects of " + ClassEntity.getClass().getName());
        this.deleteSQL("DELETE FROM " + ClassEntity.getName());
        LoggerUtility.getSingleton().logInfo(Repository.class, "Finished deleting all Objects ");                
    }
    
    final public Object delete(final Object Object) throws Exception {

        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Deleting Object " + Object.getClass().getName());
        
        if(!(Object instanceof Log)){
            insertLog(Object,"delete",null);
        }
        
        //Delete the license
        HibernateUtil.getSingleton().getSession().delete(Object);
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Finished deleting Object ");
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        return Object;
    }
    
    final public void deleteSQL(String sqlQuery) throws Exception{
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Deleting sql " + sqlQuery);
        
        insertLog(null,"delete",sqlQuery);
        this.updateSQL(sqlQuery);
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Finishing deleting sql ");
    }
    
    final public void deleteByCodigo(final String codigo) throws Exception{        
        this.deleteSQL("DELETE FROM " + ClassEntity.getName() + " WHERE codigo = " + codigo);
    }
    
    final public void deleteByCode(final String code) throws Exception{
        
        HibernateUtil.getSingleton().openSession(ClassEntity);
        final String stringQuery = "delete " + ClassEntity.getName() + " where code = :code";
        LoggerUtility.getSingleton().logInfo(Repository.class, "Deleting by code: " + stringQuery);
        final Query query = HibernateUtil.getSingleton().getSession().createQuery(stringQuery);
        query.setParameter("code", code);
        int result = query.executeUpdate();
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Deleting by code finished with result: " + result);
    }
    
    public Object getByCode(final String code) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM " + ClassEntity.getName() + " where code = :code";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("code", code);
        Object Object = query.list().size() > 0 ? query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Object;
    }
    
    
    final public Object getByCod(final String cod) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM " + ClassEntity.getName() + " where cod = :cod";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("cod", cod);
        Object Object = query.list().size() > 0 ? query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Object;
    }
    
    final public Object getByDescription(final String description) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM " + ClassEntity.getName() + " where description = :description";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("description", description);
        Object Object = query.list().size() > 0 ? query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Object;
    }
    
    final public List<?> getAllByNameFilter(final String filter) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        Query query = HibernateUtil.getSingleton().getSession().createQuery("from " + ClassEntity.getName() + " where name like '%:filter%'");
        query.setParameter("filter", filter);
        List<?> list = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return list;
    }
    
    final public List<?> getAllByCodeFilter(final String filter) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        Query query = HibernateUtil.getSingleton().getSession().createQuery("from " + ClassEntity.getName() + " where code like '%:filter%'");
        query.setParameter("filter", filter);
        List<?> list = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return list;
    }
    
    final public List<?> getAllByCode(final String code) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        Query query = HibernateUtil.getSingleton().getSession().createQuery("from " + ClassEntity.getName() + " where code = :code");
        query.setParameter("code", code);
        List<?> list = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return list;
    }
    
    final public List<?> getAllByDescriptionFilter(final String filter) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        Query query = HibernateUtil.getSingleton().getSession().createQuery("from " + ClassEntity.getName() + " where description like '%:filter%'");
        query.setParameter("filter", filter);
        List<?> list = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return list;
    }
    
    final public Object getByName(final String name) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        String hql = "FROM " + ClassEntity.getName() + " where name = :name";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("name", name);
        Object Object = query.list().size() > 0 ? query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Object;
    }
    
    /**
    * Sets a field value on a given object
    *
    * @param targetObject the object to set the field value on
    * @param fieldName    exact name of the field
    * @param fieldValue   value to set on the field
    * @return true if the value was successfully set, false otherwise
    */
   private void setField(Object targetObject, String fieldName, Object fieldValue) throws Exception {
       Field field;
       try {
           field = targetObject.getClass().getDeclaredField(fieldName);
       } catch (NoSuchFieldException e) {
           field = null;
       }
       Class superClass = targetObject.getClass().getSuperclass();
       while (field == null && superClass != null) {
           try {
               field = superClass.getDeclaredField(fieldName);
           } catch (NoSuchFieldException e) {
               superClass = superClass.getSuperclass();
           }
       }
       if (field == null) {
           return;
       }
       field.setAccessible(true);       
       field.set(targetObject, fieldValue);                  
   }

   //This method do not save as normal others repositories methods
    final public void saveInNewConnection(Object Object) throws Exception {
        
        final String user = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getCode();
        final String sucursal = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getSucu();
        final String station = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getEstac();
        
        setField(Object, "sucu", sucursal);
        setField(Object, "nocaj", station);
        setField(Object, "estac", user);
        setField(Object, "falt", new Date());
        setField(Object, "fmod", new Date());
        
        final Session Session = HibernateUtil.getSingleton().getSessionFactoryCurrent().openSession();        
        Session.save(Object);        
        Session.close();
    }
    
    public Object save(final Object Object) throws Exception{
                
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Saving object " + Object.getClass().getName());
        
        final String user = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getCode();
        final String sucursal = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getSucu();
        final String station = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getEstac();
                
        setField(Object, "sucu", sucursal);
        setField(Object, "nocaj", station);
        setField(Object, "estac", user);
        setField(Object, "falt", new Date());
        setField(Object, "fmod", new Date());
        
        //Save
        HibernateUtil.getSingleton().getSession().save(Object);                
        
        if(Object instanceof Supplier){
                        
            final Supplier Supplier = (Supplier)Object;
            RepositoryFactory.getInstance().getConsecsRepository().updateConsecSupplier(Supplier.getSerie());
        }
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Finishing Saving object ");
        
        if(!(Object instanceof Log)){
            insertLog(Object,"save",null);
        }        
        
        //Close database
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Object;
    }
    
    final public void updateSQL(String sqlQuery) throws Exception{
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Updating sql " + sqlQuery);                
                
        if(!sqlQuery.toLowerCase().startsWith("delete from") && !sqlQuery.toLowerCase().contains("where")){
            
            final String user = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getCode();
            final String sucursal = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getSucu();
            final String station = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getEstac();
        
            sqlQuery = sqlQuery + ", estac = \"" + user + "\", sucu = \"" + sucursal + "\", nocaj = \"" + station + "\"";
        }        
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Running query sql " + sqlQuery);                
        
        HibernateUtil.getSingleton().getSession().createSQLQuery(sqlQuery).executeUpdate();
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Finished updating sql ");
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
    }
    
    final public Object update(final Object Object) throws Exception{
    
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Updating object " + Object.getClass().getName());
        
        final String user = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getCode();
        final String sucursal = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getSucu();
        final String station = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getEstac();
                
        setField(Object, "sucu", sucursal);
        setField(Object, "nocaj", station);
        setField(Object, "estac", user);
        setField(Object, "fmod", new Date());
        
        //Save
        HibernateUtil.getSingleton().getSession().update(Object);
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Finished updated");
        
        if(!(Object instanceof Log)){
            insertLog(Object,"update",null);
        }
                        
            
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Object;
    }
    
    
    private void insertLog(final Object Object, final String accio, final String query) throws Exception{
        
        //No log for dbempresas operation tables         
        if(Object instanceof BasDats || Object instanceof License || Object instanceof ServerSession){
            return;
        }
        
        String cod = "INDETERMINATE";        
        
        if(Object==null){
            cod = query;
            
            LoggerUtility.getSingleton().logInfo(Repository.class, "Inserting log for query: " + query);
        }
        else{
            
            LoggerUtility.getSingleton().logInfo(Repository.class, "Inserting log for Object: " + Object.getClass().getName());
            
            if(Object instanceof Company){
                Company Company = (Company)Object;
                cod = Company.getCompanyCode();
            }
            else if(Object instanceof Measure){
                Measure Measure = (Measure)Object;
                cod = Measure.getCode();
            }
            else if(Object instanceof Marcs){
                Marcs Marcs = (Marcs)Object;
                cod = Marcs.getCode();
            }
            else if(Object instanceof Lugs){
                Lugs Lugs = (Lugs)Object;
                cod = Lugs.getCode();
            }
            else if(Object instanceof Line){
                Line Line = (Line)Object;
                cod = Line.getCode();
            }
            else if(Object instanceof Kits){
                Kits Kits = (Kits)Object;
                cod = Kits.getCode();
            }
            else if(Object instanceof ImpuesXProduct){
                ImpuesXProduct ImpuesXProduct = (ImpuesXProduct)Object;
                cod = ImpuesXProduct.getCode() + "-|-" + ImpuesXProduct.getImpue();
            }
            else if(Object instanceof Giro){
                Giro Giro = (Giro)Object;
                cod = Giro.getGir();
            }
            else if(Object instanceof Fabs){
                Fabs Fabs = (Fabs)Object;
                cod = Fabs.getCod();
            }
            else if(Object instanceof Company){
                Company Emps = (Company)Object;
                cod = Emps.getCompanyCode();
            }
            else if(Object instanceof Conceps){
                Conceps Conceps = (Conceps)Object;
                cod = Conceps.getCode();
            }
            else if(Object instanceof Conceppag){
                Conceppag Conceppag = (Conceppag)Object;
                cod = Conceppag.getConcep();
            }
            else if(Object instanceof Concepnot){
                Concepnot Concepnot = (Concepnot)Object;
                cod = Concepnot.getConcep();
            }
            else if(Object instanceof Comprs){
                Comprs Comprs = (Comprs)Object;
                cod = Comprs.getCodcomp();
            }
            else if(Object instanceof Company){
                Company Company = (Company)Object;
                cod = Company.getCompanyCode();
            }
            else if(Object instanceof Compa){
                Compa Compa = (Compa)Object;
                cod = Compa.getCompa();
            }
            else if(Object instanceof Coin){
                Coin Coin = (Coin)Object;
                cod = Coin.getC_moneda();
            }
            else if(Object instanceof Clasificacion){
                Clasificacion Clasificacion = (Clasificacion)Object;
                cod = Clasificacion.getCod();
            }
            else if(Object instanceof Banco){
                Banco Banco = (Banco)Object;
                cod = Banco.getCuentabanco();
            }
            else if(Object instanceof Anaqs){
                Anaqs Anaqs = (Anaqs)Object;
                cod = Anaqs.getCode();
            }
            else if(Object instanceof Aduana){
                Aduana Aduana = (Aduana)Object;
                cod = Aduana.getCodigo();
            }
            else if(Object instanceof Zona){
                Zona Zona = (Zona)Object;
                cod = Zona.getCod();
            }
            else if(Object instanceof Warehouse){
                Warehouse Warehouse = (Warehouse)Object;
                cod = Warehouse.getCode();
            }
            else if(Object instanceof User){
                User User = (User)Object;
                cod = User.getEstac();
            }
            else if(Object instanceof Unid){
                Unid Unid = (Unid)Object;
                cod = Unid.getCode();
            }
            else if(Object instanceof Tips){
                Tips Tips = (Tips)Object;
                cod = Tips.getCode();
            }
            else if(Object instanceof Tipactfij){
                Tipactfij Tipactfij = (Tipactfij)Object;
                cod = Tipactfij.getCode();
            }
            else if(Object instanceof Tax){
                Tax Tax = (Tax)Object;
                cod = Tax.getCode();
            }
            else if(Object instanceof Supplier){
                Supplier Supplier = (Supplier)Object;
                cod = Supplier.getCode();
            }
            else if(Object instanceof Sucursal){
                Sucursal Sucursal = (Sucursal)Object;
                cod = Sucursal.getCode();
            }
            else if(Object instanceof Subramos){
                Subramos Subramos = (Subramos)Object;
                cod = Subramos.getCode();
            }
            else if(Object instanceof Sectores){
                Sectores Sectores = (Sectores)Object;
                cod = Sectores.getCode();
            }
            else if(Object instanceof Sales){
                Sales Sales = (Sales)Object;
                cod = String.valueOf(Sales.getId());
            }
            else if(Object instanceof Rubr){
                Rubr Rubr = (Rubr)Object;
                cod = Rubr.getCode();
            }
            else if(Object instanceof Responsable){
                Responsable Responsable = (Responsable)Object;
                cod = Responsable.getCode();
            }
            else if(Object instanceof Product){
                Product Product = (Product)Object;
                cod = Product.getCode();
            }
            else if(Object instanceof Pes){
                Pes Pes = (Pes)Object;
                cod = Pes.getCode();
            }
            else if(Object instanceof Pedidos){
                Pedidos Pedidos = (Pedidos)Object;
                cod = Pedidos.getCodemp();
            }
            else if(Object instanceof Payment){
                Payment Payment = (Payment)Object;
                cod = Payment.getCode();
            }
            else if(Object instanceof Ords){
                Ords Ords = (Ords)Object;
                cod = String.valueOf(Ords.getId());
            }
            else if(Object instanceof MetogoPago){
                MetogoPago MetogoPago = (MetogoPago)Object;
                cod = MetogoPago.getCode();
            }
            else if(Object instanceof Meds){
                Meds Meds = (Meds)Object;
                cod = Meds.getCode();
            }
        }
        
        final Log Log = new Log();
        Log.setCode(cod);
        Log.setAccio(accio);
        
        RepositoryFactory.getInstance().getLogsRepository().save(Log);
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Log saved");
    }
}