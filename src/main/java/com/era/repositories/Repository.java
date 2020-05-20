/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.logger.LoggerUtility;
import com.era.models.Aduana;
import com.era.models.Almas;
import com.era.models.Anaqs;
import com.era.models.Banco;
import com.era.models.BasDats;
import com.era.models.CCodigopostal;
import com.era.models.CCountry;
import com.era.models.CRegimenfiscal;
import com.era.models.Clasemp;
import com.era.models.Clasificacion;
import com.era.models.Clasjeracli;
import com.era.models.Clasjeraprod;
import com.era.models.Clasjeraprov;
import com.era.models.Clasprod;
import com.era.models.Clasprov;
import com.era.models.Coin;
import com.era.models.Colos;
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
import com.era.models.Tall;
import com.era.models.Tax;
import com.era.models.Tipactfij;
import com.era.models.Tips;
import com.era.models.Ubiad;
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
public class Repository {
    
    protected Session session;
    private final Class ClassEntity;
    
    
    
    
    protected Repository(final Class ClassEntity){
        
        this.ClassEntity = ClassEntity;
    }
    
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    
    public List<?> getAllByPage(final int pageNumber, int pageSize) throws Exception {
        
        //Open database
        this.openSession();
        
        String hql = "FROM " + ClassEntity.getName();
        Query query = session.createQuery(hql);
        query.setFirstResult(pageNumber - 1);
        query.setMaxResults(pageSize);
        List<?> records = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return records;
    }
    
    public void openSession() throws Exception {
        
        //Determine if open dbempresas or a local one
        if( ClassEntity.getName().compareTo(CCountry.class.getName())==0 ||
            ClassEntity.getName().compareTo(CCodigopostal.class.getName())==0 ||
            ClassEntity.getName().compareTo(CRegimenfiscal.class.getName())==0 || 
            ClassEntity.getName().compareTo(BasDats.class.getName())==0 ||
            ClassEntity.getName().compareTo(License.class.getName())==0 || 
            ClassEntity.getName().compareTo(ServerSession.class.getName())==0){
            HibernateUtil.getSingleton().connectToDbEmpresas();
        }
        else{
            HibernateUtil.getSingleton().connectToDbLocal();
        }
        
        //Open the session
        session = HibernateUtil.getSingleton().getSessionFactory().openSession();     
    }
    
    final public long getCount() throws Exception {
        
        //Open database
        this.openSession();
        
        String hql = "select count(*) from " + ClassEntity.getName();
        Query query = session.createQuery(hql);        
        Iterator count = query.iterate();
        
        //Close database
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return (long) count.next();
    }
    
    final public Object getByID(final int id) throws Exception {
                        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Geting by id " + id + " from " + ClassEntity.getName());
        
        final Object Object = session.get(ClassEntity, id);
                
        LoggerUtility.getSingleton().logInfo(Repository.class, "Finished getting by id");
        
        //Return the response model
        return Object;
    }
    
    final public List<?> getAll() throws Exception{
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Geting all objects from " + ClassEntity.getName());
        
        String hql = "FROM " + ClassEntity.getName();
        Query query = session.createQuery(hql);        
        List<?> list = query.list();
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Finished geting all objects ");
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return list;
    }
        
    final public List<?> getAllLike(final List<String> likes, final String search) throws Exception{
    
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String cad = "WHERE";
        cad = likes.stream().map((like) -> " " + like + " ('%" + search + "%') OR").reduce(cad, String::concat);
        if(likes.isEmpty()){
            cad = "";
        }
        else{
            cad = cad.substring(0,cad.length() - 3);
        }        
        
        String hql = "FROM " + ClassEntity.getName() + " " + cad;
        Query query = session.createQuery(hql);        
        List<?> list = query.list();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return list;
    }
    
    final public Object getByNoRefer(final String norefer) throws Exception{
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String hql = "FROM " + ClassEntity.getName() + " WHERE norefer = :norefer";
        Query query = session.createQuery(hql);    
        query.setParameter("norefer", norefer);
        Object Object = query.list().size()>0?query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
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
    
    final public Object delete(final Object Object) throws Exception {

        //Open database
        this.openSession();
        session.beginTransaction();
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Deleting Object " + Object.getClass().getName());
        
        if(!(Object instanceof Log)){
            insertLog(Object,"delete",null);
        }
        
        //Delete the license
        session.delete(Object);
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Finished deleting Object ");
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
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
        this.deleteSQL("DELETE FROM " + ClassEntity.getName() + " WHERE code = \"" + code + "\"");
    }
    
    final public Object getByCode(final String code) throws Exception {
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String hql = "FROM " + ClassEntity.getName() + " where code = :code";
        Query query = session.createQuery(hql);
        query.setParameter("code", code);
        Object Object = query.list().size() > 0 ? query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Object;
    }
    
    
    final public Object getByCod(final String cod) throws Exception {
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String hql = "FROM " + ClassEntity.getName() + " where cod = :cod";
        Query query = session.createQuery(hql);
        query.setParameter("cod", cod);
        Object Object = query.list().size() > 0 ? query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Object;
    }
    
    final public Object getByDescription(final String description) throws Exception {
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String hql = "FROM " + ClassEntity.getName() + " where description = :description";
        Query query = session.createQuery(hql);
        query.setParameter("description", description);
        Object Object = query.list().size() > 0 ? query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Object;
    }
    
    final public List<?> getAllByNameFilter(final String filter) throws Exception{
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("from " + ClassEntity.getName() + " where name like '%:filter%'");
        query.setParameter("filter", filter);
        List<?> list = query.list();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return list;
    }
    
    final public List<?> getAllByCodeFilter(final String filter) throws Exception{
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("from " + ClassEntity.getName() + " where code like '%:filter%'");
        query.setParameter("filter", filter);
        List<?> list = query.list();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return list;
    }
    
    final public List<?> getAllByDescriptionFilter(final String filter) throws Exception{
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("from " + ClassEntity.getName() + " where description like '%:filter%'");
        query.setParameter("filter", filter);
        List<?> list = query.list();
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return list;
    }
    
    final public Object getByName(final String name) throws Exception {
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        String hql = "FROM " + ClassEntity.getName() + " where name = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        Object Object = query.list().size() > 0 ? query.list().get(0):null;
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
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

    final public Object save(final Object Object) throws Exception{
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Saving object " + Object.getClass().getName());
        
        final String user = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getStation();
        final String sucursal = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getSucursal();
        final String station = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getEstacglo();
                
        setField(Object, "sucu", sucursal);
        setField(Object, "nocaj", station);
        setField(Object, "estac", user);
        setField(Object, "falt", new Date());
        setField(Object, "fmod", new Date());
        
        //Save
        session.save(Object);
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Finishing Saving object ");
        
        if(!(Object instanceof Log)){
            insertLog(Object,"save",null);
        }        
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
        //Return the result model
        return Object;
    }
    
    final public void updateSQL(String sqlQuery) throws Exception{
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Updating sql " + sqlQuery);
        
        final String user = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getStation();
        final String sucursal = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getSucursal();
        final String station = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getEstacglo();
                
        sqlQuery = sqlQuery + ", estac = \"" + user + "\", sucu = \"" + sucursal + "\", nocaj = \"" + station + "\"";
        
        session.createSQLQuery(sqlQuery).executeUpdate();
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Finished updating sql ");
        
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
    }
    
    final public Object update(final Object Object) throws Exception{
        
        //Open database
        this.openSession();
        session.beginTransaction();
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Updating object " + Object.getClass().getName());
        
        final String user = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getStation();
        final String sucursal = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getSucursal();
        final String station = UtilitiesFactory.getSingleton().getSessionUtility().getUser().getEstacglo();
                
        setField(Object, "sucu", sucursal);
        setField(Object, "nocaj", station);
        setField(Object, "estac", user);
        setField(Object, "fmod", new Date());
        
        //Save
        session.update(Object);
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Finished updated");
        
        if(!(Object instanceof Log)){
            insertLog(Object,"update",null);
        }
                
        //Close database
        session.getTransaction().commit();
        HibernateUtil.getSingleton().shutdown();
        
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
                cod = Marcs.getCod();
            }
            else if(Object instanceof Lugs){
                Lugs Lugs = (Lugs)Object;
                cod = Lugs.getCod();
            }
            else if(Object instanceof Line){
                Line Line = (Line)Object;
                cod = Line.getCode();
            }
            else if(Object instanceof Kits){
                Kits Kits = (Kits)Object;
                cod = Kits.getCodkit();
            }
            else if(Object instanceof ImpuesXProduct){
                ImpuesXProduct ImpuesXProduct = (ImpuesXProduct)Object;
                cod = ImpuesXProduct.getProdu() + "-|-" + ImpuesXProduct.getImpue();
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
                cod = Conceps.getConcep();
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
            else if(Object instanceof Colos){
                Colos Colos = (Colos)Object;
                cod = Colos.getCod();
            }
            else if(Object instanceof Coin){
                Coin Coin = (Coin)Object;
                cod = Coin.getC_moneda();
            }
            else if(Object instanceof Clasprov){
                Clasprov Clasprov = (Clasprov)Object;
                cod = Clasprov.getCod();
            }
            else if(Object instanceof Clasprod){
                Clasprod Clasprod = (Clasprod)Object;
                cod = Clasprod.getCod();
            }
            else if(Object instanceof Clasjeraprov){
                Clasjeraprov Clasjeraprov = (Clasjeraprov)Object;
                cod = Clasjeraprov.getClas();
            }
            else if(Object instanceof Clasjeraprod){
                Clasjeraprod Clasjeraprod = (Clasjeraprod)Object;
                cod = Clasjeraprod.getClas();
            }
            else if(Object instanceof Clasjeracli){
                Clasjeracli Clasjeracli = (Clasjeracli)Object;
                cod = Clasjeracli.getClas();
            }
            else if(Object instanceof Clasificacion){
                Clasificacion Clasificacion = (Clasificacion)Object;
                cod = Clasificacion.getCod();
            }
            else if(Object instanceof Clasemp){
                Clasemp Clasemp = (Clasemp)Object;
                cod = Clasemp.getCod();
            }            
            else if(Object instanceof Banco){
                Banco Banco = (Banco)Object;
                cod = Banco.getCuentabanco();
            }
            else if(Object instanceof Anaqs){
                Anaqs Anaqs = (Anaqs)Object;
                cod = Anaqs.getCod();
            }
            else if(Object instanceof Almas){
                Almas Almas = (Almas)Object;
                cod = Almas.getAlma();
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
                cod = User.getEstacglo();
            }
            else if(Object instanceof Unid){
                Unid Unid = (Unid)Object;
                cod = Unid.getCode();
            }
            else if(Object instanceof Ubiad){
                Ubiad Ubiad = (Ubiad)Object;
                cod = Ubiad.getCod();
            }
            else if(Object instanceof Tips){
                Tips Tips = (Tips)Object;
                cod = Tips.getCod();
            }
            else if(Object instanceof Tipactfij){
                Tipactfij Tipactfij = (Tipactfij)Object;
                cod = Tipactfij.getTip();
            }
            else if(Object instanceof Tax){
                Tax Tax = (Tax)Object;
                cod = Tax.getCode();
            }
            else if(Object instanceof Tall){
                Tall Tall = (Tall)Object;
                cod = Tall.getCod();
            }
            else if(Object instanceof Supplier){
                Supplier Supplier = (Supplier)Object;
                cod = Supplier.getCode();
            }
            else if(Object instanceof Sucursal){
                Sucursal Sucursal = (Sucursal)Object;
                cod = Sucursal.getCod();
            }
            else if(Object instanceof Subramos){
                Subramos Subramos = (Subramos)Object;
                cod = Subramos.getCodigo();
            }
            else if(Object instanceof Sectores){
                Sectores Sectores = (Sectores)Object;
                cod = Sectores.getCodigo();
            }
            else if(Object instanceof Sales){
                Sales Sales = (Sales)Object;
                cod = String.valueOf(Sales.getId());
            }
            else if(Object instanceof Rubr){
                Rubr Rubr = (Rubr)Object;
                cod = Rubr.getCod();
            }
            else if(Object instanceof Responsable){
                Responsable Responsable = (Responsable)Object;
                cod = Responsable.getCod();
            }
            else if(Object instanceof Product){
                Product Product = (Product)Object;
                cod = Product.getCodeProduct();
            }
            else if(Object instanceof Pes){
                Pes Pes = (Pes)Object;
                cod = Pes.getCod();
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
                cod = Meds.getCod();
            }
        }
        
        final Log Log = new Log();
        Log.setCod(cod);
        Log.setAccio(accio);
        
        RepositoryFactory.getInstance().getLogRepository().save(Log);
        
        LoggerUtility.getSingleton().logInfo(Repository.class, "Log saved");
    }
}