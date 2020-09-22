/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories.utils;

import com.era.logger.LoggerUtility;
import com.era.repositories.models.HibernateConfigModel;
import java.util.ArrayList;
import com.era.models.*;
import java.sql.Connection;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.engine.SessionFactoryImplementor;

/**
 *
 * @author PC
 */
public class HibernateUtil {
    
    //Singleton
    private static HibernateUtil HibernateUtil;
    
    private SessionFactory sessionFactoryCurrent;
    private SessionFactory sessionFactoryDbEmpresas;
    private SessionFactory sessionFactoryLocal;
    
    private HibernateConfigModel HibernateConfigModelCurrent;
    private HibernateConfigModel HibernateConfigModelDbEmpresas;
    private HibernateConfigModel HibernateConfigModelLocal;
        
    private boolean sessionLocalInTransacction;    
    
    private Class ClassHasConnection;
    
    private Session Session;
    private Session SessionDbempresas;
    
    
    
    
    
    private HibernateUtil(){
        //Singleton
    }

    public SessionFactory getSessionFactoryCurrent() {
        return sessionFactoryCurrent;
    }

    public SessionFactory getSessionFactoryDbEmpresas() {
        return sessionFactoryDbEmpresas;
    }

    public SessionFactory getSessionFactoryLocal() {
        return sessionFactoryLocal;
    }
    
    public Connection getDBEmpresasJDBCConnection() throws Exception {
        
        SessionFactoryImplementor sessionFactoryImplementation = (SessionFactoryImplementor) sessionFactoryDbEmpresas;
        ConnectionProvider connectionProvider = sessionFactoryImplementation.getConnectionProvider();
        return connectionProvider.getConnection();
    }
    
    public Connection getLocalJDBCConnection() throws Exception {
        
        SessionFactoryImplementor sessionFactoryImplementation = (SessionFactoryImplementor) sessionFactoryLocal;
        ConnectionProvider connectionProvider = sessionFactoryImplementation.getConnectionProvider();
        return connectionProvider.getConnection();
    }
    
    final static public HibernateUtil getSingleton(){
        if(HibernateUtil==null){
            HibernateUtil = new HibernateUtil();
        }
        return HibernateUtil;
    } 

    public Session getSession() {
        
        if(SessionDbempresas!=null){
            return SessionDbempresas;
        }
        else{
            return Session;
        }
    }
            
    public void useDbEmpresas() {
        this.HibernateConfigModelCurrent = this.HibernateConfigModelDbEmpresas;
        this.sessionFactoryCurrent = this.sessionFactoryDbEmpresas;
    }
    public void useDbLocal() {
        this.HibernateConfigModelCurrent = this.HibernateConfigModelLocal;
        this.sessionFactoryCurrent = this.sessionFactoryLocal;
    }

    public void setHibernateConfigModelDbEmpresas(HibernateConfigModel HibernateConfigModelDbEmpresas) {
        this.HibernateConfigModelDbEmpresas = HibernateConfigModelDbEmpresas;
    }    
    public void createDbEmpresas() throws Exception {
                
        final AnnotationConfiguration AnnotationConfiguration = createSessionFactoryFromHibernateConfigModel(HibernateConfigModelDbEmpresas, "create");        
        this.sessionFactoryDbEmpresas = this.buildSessionFactoryFordbempresas(AnnotationConfiguration);
    }
    public void loadDbEmpresas() throws Exception {
        
        if(this.sessionFactoryDbEmpresas == null){
            final AnnotationConfiguration AnnotationConfiguration = createSessionFactoryFromHibernateConfigModel(HibernateConfigModelDbEmpresas, "none");        
            this.sessionFactoryDbEmpresas = this.buildSessionFactoryFordbempresas(AnnotationConfiguration);                
        }        
    }

    public void setHibernateConfigModelLocal(HibernateConfigModel HibernateConfigModelLocal) {
        this.HibernateConfigModelLocal = HibernateConfigModelLocal;
    }        
    public void createDbLocal() throws Exception {
        
        final AnnotationConfiguration AnnotationConfiguration = createSessionFactoryFromHibernateConfigModel(HibernateConfigModelLocal, "create");
        this.sessionFactoryLocal = this.buildSessionFactoryForLocal(AnnotationConfiguration);
    }
    public void loadDbLocal() throws Exception {
        
        if(this.sessionFactoryLocal == null){
            final AnnotationConfiguration AnnotationConfiguration = createSessionFactoryFromHibernateConfigModel(HibernateConfigModelLocal, "none");        
            this.sessionFactoryLocal = this.buildSessionFactoryForLocal(AnnotationConfiguration);
        }        
    }
    public HibernateConfigModel getHibernateConfigModelCurrent() {
        return HibernateConfigModelCurrent;
    }
    public HibernateConfigModel getHibernateConfigModelDbempresas() {
        return HibernateConfigModelDbEmpresas;
    }
    public HibernateConfigModel getHibernateConfigModelLocal() {
        return HibernateConfigModelLocal;
    }
    
    public HibernateConfigModel createLocalHibernateConfigModel(final String database) {
        
        final HibernateConfigModel HibernateConfigModel_ = new HibernateConfigModel();        
        HibernateConfigModel_.setInstance(this.HibernateConfigModelCurrent.getInstance());
        HibernateConfigModel_.setPassword(this.HibernateConfigModelCurrent.getPassword());
        HibernateConfigModel_.setPort(this.HibernateConfigModelCurrent.getPort());
        HibernateConfigModel_.setUrl(this.HibernateConfigModelCurrent.getUrl());
        HibernateConfigModel_.setUser(this.HibernateConfigModelCurrent.getUser());
        HibernateConfigModel_.setDatabase(database);
                
        return HibernateConfigModel_;
    }
    
    private AnnotationConfiguration createSessionFactoryFromHibernateConfigModel(HibernateConfigModel HibernateConfigModel, final String hbm2ddlauto) throws Exception{
        final AnnotationConfiguration AnnotationConfiguration = new AnnotationConfiguration().configure();
        AnnotationConfiguration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        AnnotationConfiguration.setProperty("hibernate.connection.url", "jdbc:mysql://" + HibernateConfigModel.getInstance() + ":" + HibernateConfigModel.getPort() + "/" + HibernateConfigModel.getDatabase());
        AnnotationConfiguration.setProperty("hibernate.connection.username", HibernateConfigModel.getUser());
        //AnnotationConfiguration.setProperty("hibernate.connection.autocommit", "true");
        AnnotationConfiguration.setProperty("hibernate.connection.password", HibernateConfigModel.getPassword());
        AnnotationConfiguration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        AnnotationConfiguration.setProperty("show_sql", "true");
        AnnotationConfiguration.setProperty("format_sql", "true");
        AnnotationConfiguration.setProperty("hibernate.hbm2ddl.auto", hbm2ddlauto);        
        return AnnotationConfiguration;
    }
    public SessionFactory buildSessionFactoryFordbempresas(final AnnotationConfiguration AnnotationConfiguration) throws Exception{
        
        //Add anotated classes
        List<Class> classes = getAnnottatedClassesFordbempresas();
        for(Class class_:classes){
            LoggerUtility.getSingleton().logInfo(HibernateUtil.class, "Adding annotated class " + class_);
            AnnotationConfiguration.addAnnotatedClass(class_);
        }

        final SessionFactory sessionFactory = AnnotationConfiguration.buildSessionFactory();
        
        return sessionFactory;
    }
    
    private SessionFactory buildSessionFactoryForLocal(final AnnotationConfiguration AnnotationConfiguration) throws Exception{
        
        //Add anotated classes
        List<Class> classes = getAnnottatedClassesForLocal();
        for(Class class_:classes){
            LoggerUtility.getSingleton().logInfo(HibernateUtil.class, "Adding annotated class " + class_);
            AnnotationConfiguration.addAnnotatedClass(class_);
        }

       final SessionFactory sessionFactory = AnnotationConfiguration.buildSessionFactory();
       return sessionFactory;
    }
    
    public void createNewLocalDatabase(final String db) throws Exception {
        
        //Get hibernate configuration file
        HibernateConfigModel HibernateConfigModel = this.getHibernateConfigModelCurrent();

        //Save the local connections params for local db
        HibernateConfigModel HibernateConfigModel_ = new HibernateConfigModel();
        HibernateConfigModel_.setInstance(HibernateConfigModel.getInstance());
        HibernateConfigModel_.setPassword(HibernateConfigModel.getPassword());
        HibernateConfigModel_.setPort(HibernateConfigModel.getPort());
        HibernateConfigModel_.setUrl(HibernateConfigModel.getUrl());
        HibernateConfigModel_.setUser(HibernateConfigModel.getUser());
        HibernateConfigModel_.setDatabase(db);
        this.setHibernateConfigModelLocal(HibernateConfigModel_);

        //Create the new company with JDBC and read all the catalogs script from disk
        MysqlScriptsUtil.getInstance().creaDB(HibernateConfigModel_.getDatabase(), HibernateConfigModel.getUser(), HibernateConfigModel.getPassword(), HibernateConfigModel.getInstance(), HibernateConfigModel.getPort());

        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " Populating database with schemas");

        //Create the hibernate schemes
        createDbLocal();

        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " Finished populating schemas");

        //Load the base catalogs for dbempresas
        MysqlScriptsUtil.getInstance().loadLocalCatalogFileIntoDatabase(HibernateConfigModel_.getDatabase(), HibernateConfigModel_.getUser(), HibernateConfigModel_.getPassword(), HibernateConfigModel_.getInstance(), HibernateConfigModel_.getPort());
    }
    
    public void begginTransaction() throws Exception  {        
        this.Session.beginTransaction();        
    }
    
    public void commitTransacton() throws Exception {
        this.Session.getTransaction().commit();
    }

    public void rollbackTransaction() throws Exception  {        
        this.Session.getTransaction().rollback();
    }
    
    private boolean isInClassesForLocal(Class Class_) throws Exception {
        return getAnnottatedClassesForLocal().contains(Class_);
    }
    
    public List<Class> getAnnottatedClassesForLocal() throws Exception {
        
        final List<Class> classes = new ArrayList<>();
        classes.add(Company.class);        
        classes.add(CFDIRelacionadosPago.class);
        classes.add(BasDats.class);
        classes.add(Banco.class);
        classes.add(Auxiliar.class);
        classes.add(Asocdesc.class);
        classes.add(AsientosContables.class);
        classes.add(Anaqs.class);        
        classes.add(Aduana.class);
        classes.add(Activos.class);
        classes.add(Actfijcat.class);
        classes.add(Actfij.class);
        classes.add(Cortszx.class);
        classes.add(Cortes.class);
        classes.add(Corrselec.class);
        classes.add(PaymentsSale.class);        
        classes.add(CorreoTerminal.class);
        classes.add(Controlexportar.class);        
        classes.add(Consec.class);
        classes.add(Confgral.class);        
        classes.add(Conceps.class);
        classes.add(Conceppag.class);
        classes.add(Concepnot.class);
        classes.add(ComprsTmp.class);
        classes.add(Comprs.class);
        classes.add(Compa.class);
        classes.add(Coin.class);
        classes.add(Clasificacion.class);        
        classes.add(GeneralConfig.class);
        classes.add(Garan.class);
        classes.add(Flujact.class);
        classes.add(Fluj.class);
        classes.add(Facturas.class);
        classes.add(Fabs.class);
        classes.add(Existalma.class);        
        classes.add(ERPermisos.class);
        classes.add(ERMmovimientosInventario.class);
        classes.add(EREjercicios.class);
        classes.add(DocumentosPago.class);
        classes.add(DocumentosOrigen.class);
        classes.add(DocumentosContabilizados.class);
        classes.add(DocumentOrigin.class);
        classes.add(Datoscp.class);
        classes.add(Cxp.class);
        classes.add(Cxc.class);
        classes.add(CuentasContables.class);        
        classes.add(Cots.class);
        classes.add(Costs.class);
        classes.add(PartcomprsTmp.class);
        classes.add(Partcomprs.class);        
        classes.add(Ords.class);
        classes.add(MovimientosPagos.class);
        classes.add(MovimientosAsientos.class);
        classes.add(Moninven.class);
        classes.add(ModificaImpuestos.class);
        classes.add(Modelprod.class);
        classes.add(Model.class);        
        classes.add(Meds.class);
        classes.add(Measure.class);
        classes.add(Maxminconf.class);
        classes.add(Marcs.class);
        classes.add(Marcprod.class);
        classes.add(Lugs.class);
        classes.add(Log.class);
        classes.add(Line.class);
        classes.add(License.class);
        classes.add(Kits.class);
        classes.add(Ingres.class);
        classes.add(IngresosEncab.class);        
        classes.add(Impuesxpartidaped.class);
        classes.add(Impuesxpartidacot.class);
        classes.add(ImpuestosXVenta.class);
        classes.add(ImpuestosXCompra.class);
        classes.add(ImpuestosVenta.class);
        classes.add(ImpuesXProduct.class);
        classes.add(HistAntiguedaddesaldo.class);
        classes.add(Giro.class);
        classes.add(Zona.class);
        classes.add(Warehouse.class);        
        classes.add(Usuarioserie.class);
        classes.add(UserPermission.class);
        classes.add(User.class);
        classes.add(Unid.class);        
        classes.add(Traspas.class);
        classes.add(Tipscamb.class);
        classes.add(Tips.class);
        classes.add(Tipactfij.class);
        classes.add(Terprodcompa.class);
        classes.add(Termarcamodelo.class);
        classes.add(Tax.class);
        classes.add(Tars.class);
        classes.add(Supplier.class);
        classes.add(Sucursal.class);
        classes.add(Subramos.class);
        classes.add(ServerSession.class);
        classes.add(Serieprod.class);
        classes.add(Serie.class);
        classes.add(Payment.class);
        classes.add(Sectores.class);
        classes.add(Sales.class);
        classes.add(Rubr.class);
        classes.add(Responsable.class);
        classes.add(Resplog.class);
        classes.add(Registroemail.class);
        classes.add(PushNotification.class);
        classes.add(Product.class);
        classes.add(Prodpart.class);
        classes.add(Prevcomprs.class);
        classes.add(Pes.class);
        classes.add(Pers.class);
        classes.add(PedidosParts.class);
        classes.add(Pedidos.class);                
        classes.add(Partvta.class);
        classes.add(PartprevcomprsTmp.class);
        classes.add(Partprevcomprs.class);
        classes.add(Partords.class);
        classes.add(Partflujact.class);
        classes.add(Partcot.class);
        return classes;
    }
    
    public List<Class> getAnnottatedClassesFordbempresas() throws Exception {
        
        final List<Class> classes = new ArrayList<>();
        classes.add(BasDats.class);
        classes.add(License.class);
        classes.add(ServerSession.class);
        classes.add(CCodigopostal.class);
        classes.add(CCountry.class);
        classes.add(CRegimenfiscal.class);
        classes.add(CClaveprodserv.class);
        classes.add(CClaveUnidad.class);
        classes.add(CAduana.class);
        classes.add(MetogoPago.class);
        classes.add(Banks.class);
        classes.add(CPaymentMethod.class);
        classes.add(CPaymentForm.class);
        classes.add(CTipoRelacion.class);
        classes.add(CTipoComprobante.class);
        classes.add(CUsoCFDI.class);        
        return classes;
    }
    
    public void closeSession(final Class ClassEntity) throws Exception {
        
        //If there is an operation in this database so ?
        if(this.SessionDbempresas==null){
            
            //If there is not a transaction in course
            if(!sessionLocalInTransacction){

                if(this.Session.getTransaction().isActive()){
                    this.Session.getTransaction().commit();
                    if(this.Session.isOpen()){
                        this.Session.close();
                    }                
                }
            }
        }
        else{
            
            if(this.SessionDbempresas.getTransaction().isActive()){
                this.SessionDbempresas.getTransaction().commit();
                if(this.SessionDbempresas.isOpen()){
                    this.SessionDbempresas.close();
                    this.SessionDbempresas = null;
                }
            }
        }
    }

    public void closeSessionInTransaction(final Class ClassEntity) throws Exception {
     
        //Set that the transaction in course has finished
        sessionLocalInTransacction = false;
        
        //Open the database in transaction
        closeSession(ClassEntity);
    }
    
    public void openSessionInTransacction(Class ClassEntity) throws Exception {
        
        //Open the databsase in transaction
        this.openSession(ClassEntity);
        
        //Set that there is a transaction in course
        sessionLocalInTransacction = true;
    }
    
    public void openSession(Class ClassEntity) throws Exception {
        
        boolean isDbEmpresaClass = false;
        final List<Class> dbEmpresasClasses = getAnnottatedClassesFordbempresas();
        for(Class clase:dbEmpresasClasses){
            if(ClassEntity.getName().compareTo(clase.getName())==0){
                isDbEmpresaClass = true;
                break;
            }
        }
        
        //Determine if open dbempresas or a local one        
        if(isDbEmpresaClass){
            useDbEmpresas();
        }
        else{
            useDbLocal();
        }
        
        boolean localDB = true;
        if(!this.isInClassesForLocal(ClassEntity)){
            localDB = false;
        }
        
        //If is in the local db
        if(localDB){
            
            //If there is not a transaction in course
            if(!sessionLocalInTransacction){

                this.Session = this.sessionFactoryCurrent.openSession();
                this.Session.beginTransaction();

                //Save who oppended the connection
                this.ClassHasConnection = ClassEntity;
            }
        }
        else{ //Else on dbempresas db
            
            this.SessionDbempresas = this.sessionFactoryCurrent.openSession();
            this.SessionDbempresas.beginTransaction();
        }
    }
    
    public AnnotationConfiguration getLocalAnnotationConfiguration() throws Exception{
        
        // Create the SessionFactory from hibernate.cfg.xml            
        final AnnotationConfiguration AnnotationConfiguration = new AnnotationConfiguration();
        List<Class> classes = this.getAnnottatedClassesForLocal();
        for(Class class_:classes){
            LoggerUtility.getSingleton().logInfo(HibernateUtil.class, "Adding annotated class " + class_);
            AnnotationConfiguration.addAnnotatedClass(class_);
        }
        return AnnotationConfiguration.configure();
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
