/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories.utils;

import com.era.logger.LoggerUtility;
import com.era.repositories.models.HibernateConfigModel;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import com.era.models.*;
import java.util.Enumeration;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author PC
 */
public class HibernateUtil {
    
    //Singleton
    private static HibernateUtil HibernateUtil;
    
    private SessionFactory sessionFactory;
    private SessionFactory sessionFactoryAnother;
 
    private Transaction Transaction;
    
    private HibernateConfigModel HibernateConfigModel;    
    private HibernateConfigModel HibernateConfigModelDbEmpresas;
    private HibernateConfigModel HibernateConfigModelLocal;
    
    private boolean reloadBuildSessionFactory;
    
    
    private HibernateUtil(){
        //Singleton
    }
    
    final static public HibernateUtil getSingleton(){
        if(HibernateUtil==null){
            HibernateUtil = new HibernateUtil();
        }
        return HibernateUtil;
    } 
    
    final public void setHibernateConfigModel(HibernateConfigModel HibernateConfigModel_){
        reloadBuildSessionFactory = true;
        HibernateConfigModel = HibernateConfigModel_;
    }

    public void setHibernateConfigModelDbEmpresas(HibernateConfigModel HibernateConfigModelDbEmpresas) {
        HibernateUtil.HibernateConfigModelDbEmpresas = HibernateConfigModelDbEmpresas;
        HibernateConfigModel = HibernateUtil.HibernateConfigModelDbEmpresas;
    }

    public void setHibernateConfigModelLocal(HibernateConfigModel HibernateConfigModelLocal) {
        HibernateUtil.HibernateConfigModelLocal = HibernateConfigModelLocal;
        HibernateConfigModel = HibernateUtil.HibernateConfigModelDbEmpresas;
    }

    public void connectToDbEmpresas() {
        setHibernateConfigModel(HibernateConfigModelDbEmpresas);
    }
    
    public void connectToDbLocal() {
        setHibernateConfigModel(HibernateConfigModelLocal);
    }
    
    public HibernateConfigModel getHibernateConfigModel() {
        return HibernateConfigModel;
    }
    
    public HibernateConfigModel createLocalHibernateConfigModel(final String database, final boolean connectToLocal) {
        
        final HibernateConfigModel HibernateConfigModel_ = new HibernateConfigModel();
        HibernateConfigModel_.setInstance(HibernateConfigModel.getInstance());
        HibernateConfigModel_.setPassword(HibernateConfigModel.getPassword());
        HibernateConfigModel_.setPort(HibernateConfigModel.getPort());
        HibernateConfigModel_.setUrl(HibernateConfigModel.getUrl());
        HibernateConfigModel_.setUser(HibernateConfigModel.getUser());
        HibernateConfigModel_.setDatabase(database);
                
        this.setHibernateConfigModelLocal(HibernateConfigModel_);
        
        if(connectToLocal){
            this.connectToDbLocal();
        }
        
        return HibernateConfigModel_;
    }
    
    public SessionFactory buildSessionFactoryFromHibernateConfigModelCreate(HibernateConfigModel HibernateConfigModel) throws Exception{
        return buildSessionFactoryFromHibernateConfigModel(HibernateConfigModel, "create");
    }
    
    public SessionFactory buildSessionFactoryFromHibernateConfigModelUpdate(HibernateConfigModel HibernateConfigModel) throws Exception{
        return buildSessionFactoryFromHibernateConfigModel(HibernateConfigModel, "update");
    }
    
    private AnnotationConfiguration getSessionFactoryFromHibernateConfigModel(HibernateConfigModel HibernateConfigModel, final String hbm2ddlauto) throws Exception{
        final AnnotationConfiguration AnnotationConfiguration = new AnnotationConfiguration().configure();
        AnnotationConfiguration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        AnnotationConfiguration.setProperty("hibernate.connection.url", "jdbc:mysql://" + HibernateConfigModel.getInstance() + ":" + HibernateConfigModel.getPort() + "/" + HibernateConfigModel.getDatabase());
        AnnotationConfiguration.setProperty("hibernate.connection.username", HibernateConfigModel.getUser());
        AnnotationConfiguration.setProperty("hibernate.connection.password", HibernateConfigModel.getPassword());
        AnnotationConfiguration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        AnnotationConfiguration.setProperty("show_sql", "true");
        AnnotationConfiguration.setProperty("format_sql", "true");
        AnnotationConfiguration.setProperty("hibernate.hbm2ddl.auto", hbm2ddlauto);
        
        reloadBuildSessionFactory = false;
        return AnnotationConfiguration;
    }
    
    public SessionFactory buildSessionFactoryFordbempresasCreate(HibernateConfigModel HibernateConfigModel) throws Exception{
        
        //Create config file
        final AnnotationConfiguration AnnotationConfiguration = getSessionFactoryFromHibernateConfigModel(HibernateConfigModel,"create");
        
        //Add anotated classes
        List<Class> classes = getAnnottatedClassesFordbempresas();
        for(Class class_:classes){
            LoggerUtility.getSingleton().logInfo(HibernateUtil.class, "Adding annotated class " + class_);
            AnnotationConfiguration.addAnnotatedClass(class_);
        }

        sessionFactory = AnnotationConfiguration.buildSessionFactory();
        
        return sessionFactory;
    }
    
    private SessionFactory buildSessionFactoryFordbempresasUpdate(HibernateConfigModel HibernateConfigModel) throws Exception{
        
        //Create config file
        final AnnotationConfiguration AnnotationConfiguration = getSessionFactoryFromHibernateConfigModel(HibernateConfigModel,"update");
        
        //Add anotated classes
        List<Class> classes = getAnnottatedClassesFordbempresas();
        for(Class class_:classes){
            LoggerUtility.getSingleton().logInfo(HibernateUtil.class, "Adding annotated class " + class_);
            AnnotationConfiguration.addAnnotatedClass(class_);
        }

        sessionFactory = AnnotationConfiguration.buildSessionFactory();
        
        return sessionFactory;
    }
    
    private SessionFactory buildSessionFactoryFordbempresasNone(HibernateConfigModel HibernateConfigModel) throws Exception{
        
        //Create config file
        final AnnotationConfiguration AnnotationConfiguration = getSessionFactoryFromHibernateConfigModel(HibernateConfigModel,"none");
        
        //Add anotated classes
        List<Class> classes = getAnnottatedClassesFordbempresas();
        for(Class class_:classes){
            LoggerUtility.getSingleton().logInfo(HibernateUtil.class, "Adding annotated class " + class_);
            AnnotationConfiguration.addAnnotatedClass(class_);
        }

        sessionFactory = AnnotationConfiguration.buildSessionFactory();
        
        return sessionFactory;
    }
    
    private SessionFactory buildSessionFactoryFordbempresas(HibernateConfigModel HibernateConfigModel, final String hbm2ddlauto) throws Exception{
        
        //Create config file
        final AnnotationConfiguration AnnotationConfiguration = getSessionFactoryFromHibernateConfigModel(HibernateConfigModel,hbm2ddlauto);
        
        //Add anotated classes
        List<Class> classes = getAnnottatedClassesFordbempresas();
        for(Class class_:classes){
            LoggerUtility.getSingleton().logInfo(HibernateUtil.class, "Adding annotated class " + class_);
            AnnotationConfiguration.addAnnotatedClass(class_);
        }

        sessionFactory = AnnotationConfiguration.buildSessionFactory();
        
        return sessionFactory;
    }
    
    
    private SessionFactory buildSessionFactoryFromHibernateConfigModel(HibernateConfigModel HibernateConfigModel, final String hbm2ddlauto) throws Exception{
        
        final AnnotationConfiguration AnnotationConfiguration = getSessionFactoryFromHibernateConfigModel(HibernateConfigModel,hbm2ddlauto);
        
        //Add anotated classes
        List<Class> classes = getAnnottatedClasses();
        for(Class class_:classes){
            LoggerUtility.getSingleton().logInfo(HibernateUtil.class, "Adding annotated class " + class_);
            AnnotationConfiguration.addAnnotatedClass(class_);
        }

        sessionFactory = AnnotationConfiguration.buildSessionFactory();
        
        return sessionFactory;
    }
    
    private SessionFactory buildSessionFactory() throws Exception 
    {
        LoggerUtility.getSingleton().logInfo(HibernateUtil.class, "Creating SessionFactory");
        
        //If the user previusly defined the connection params use them
        if(HibernateConfigModel != null){
            
            //Create config file
            final AnnotationConfiguration AnnotationConfiguration = getSessionFactoryFromHibernateConfigModel(HibernateConfigModel,"none");
            
            LoggerUtility.getSingleton().logInfo(HibernateUtil.class, "Building session factory from global HibernateConfigModel");
            LoggerUtility.getSingleton().logInfo(HibernateUtil.class, "Building session factory from global instance: " + HibernateConfigModel.getInstance());
            LoggerUtility.getSingleton().logInfo(HibernateUtil.class, "Building session factory from global database: " + HibernateConfigModel.getDatabase());
            LoggerUtility.getSingleton().logInfo(HibernateUtil.class, "Building session factory from global port: " + HibernateConfigModel.getPort());
            LoggerUtility.getSingleton().logInfo(HibernateUtil.class, "Building session factory from global username: " + HibernateConfigModel.getUser());
            LoggerUtility.getSingleton().logInfo(HibernateUtil.class, "Building session factory from global password: " + HibernateConfigModel.getPassword());                

            List<Class> classes;
            if(HibernateConfigModel.getDatabase().toLowerCase().compareTo("dbempresas")==0){
                classes = this.getAnnottatedClassesFordbempresas();                
            }
            else{
                classes = getAnnottatedClasses();
            }
            
            //Add anotated classes            
            for(Class class_:classes){
                LoggerUtility.getSingleton().logInfo(HibernateUtil.class, "Adding annotated class " + class_);
                AnnotationConfiguration.addAnnotatedClass(class_);
            }

            sessionFactory = AnnotationConfiguration.buildSessionFactory();
            return sessionFactory;
        }
        else{
            
            // Create the SessionFactory from hibernate.cfg.xml                            
            final AnnotationConfiguration AnnotationConfiguration = getAnnotationConfiguration();                
            return AnnotationConfiguration.configure().buildSessionFactory();
        }                    
    }
 
    public AnnotationConfiguration getAnnotationConfiguration() throws Exception{
        
        // Create the SessionFactory from hibernate.cfg.xml            
        final AnnotationConfiguration AnnotationConfiguration = new AnnotationConfiguration();
        List<Class> classes = getAnnottatedClasses();
        for(Class class_:classes){
            LoggerUtility.getSingleton().logInfo(HibernateUtil.class, "Adding annotated class " + class_);
            AnnotationConfiguration.addAnnotatedClass(class_);
        }
        return AnnotationConfiguration.configure();
    }
    
    public void openSessionInTransaction() throws Exception  {        
        Transaction = getSessionFactory().openSession().beginTransaction();
    }
    
    public void commitTransacton() throws Exception {
        Transaction.commit();
        shutdown();
    }
    
    public SessionFactory getSessionFactory() throws Exception {
        
        if(sessionFactory==null || reloadBuildSessionFactory){
            sessionFactory = buildSessionFactory();
        }            
        
        return sessionFactory;
    }
 
    /**
    * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
    *   
    * @param packageName The base package
    * @return The classes
    * @throws ClassNotFoundException
    * @throws IOException
    */
   private Class[] getClasses(String packageName)
           throws ClassNotFoundException, IOException {
       ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
       assert classLoader != null;
       String path = packageName.replace('.', '/');
       Enumeration<URL> resources = classLoader.getResources(path);
       List<File> dirs = new ArrayList<>();
       while (resources.hasMoreElements()) {
           URL resource = resources.nextElement();
           dirs.add(new File(resource.getFile()));
       }
       ArrayList<Class> classes = new ArrayList<>();
       for (File directory : dirs) {
           classes.addAll(findClasses(directory, packageName));
       }
       return classes.toArray(new Class[classes.size()]);
   }
   
   /**
    * Recursive method used to find all classes in a given directory and subdirs.
    *
    * @param directory   The base directory
    * @param packageName The package name for classes found inside the base directory
    * @return The classes
    * @throws ClassNotFoundException
    */
   private List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
       List<Class> classes = new ArrayList<>();
       if (!directory.exists()) {
           return classes;
       }
       File[] files = directory.listFiles();
       for (File file : files) {
           if (file.isDirectory()) {
               assert !file.getName().contains(".");
               classes.addAll(findClasses(file, packageName + "." + file.getName()));
           } else if (file.getName().endsWith(".class")) {
               classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
           }
       }
       return classes;
   }

    private List<Class> getAnnottatedClasses() throws Exception {
        
        final List<Class> classes = new ArrayList<>();
        classes.add(Company.class);
        classes.add(CTipoRelacion.class);
        classes.add(CTipoComprobante.class);        
        classes.add(CPaymentMethod.class);
        classes.add(CPaymentForm.class);
        classes.add(CFDIRelacionadosPago.class);
        classes.add(CCoin.class);
        classes.add(CClaveprodserv.class);
        classes.add(CClaveUnidad.class);
        classes.add(CAduana.class);
        classes.add(BasDats.class);
        classes.add(Banco.class);
        classes.add(Auxiliar.class);
        classes.add(Asocdesc.class);
        classes.add(AsientosContables.class);
        classes.add(Anaqs.class);
        classes.add(Almas.class);
        classes.add(Aduana.class);
        classes.add(Activos.class);
        classes.add(Actfijcat.class);
        classes.add(Actfij.class);
        classes.add(Cortszx.class);
        classes.add(Cortes.class);
        classes.add(Corrselec.class);
        classes.add(CorreoTerminal.class);
        classes.add(Controlexportar.class);
        classes.add(Contras.class);        
        classes.add(Consec.class);
        classes.add(Confgral.class);        
        classes.add(Conceps.class);
        classes.add(Conceppag.class);
        classes.add(Concepnot.class);
        classes.add(ComprsTmp.class);
        classes.add(Comprs.class);        
        classes.add(Compa.class);
        classes.add(Colos.class);
        classes.add(Coin.class);
        classes.add(Clasprov.class);
        classes.add(Clasprod.class);
        classes.add(Clasjeraprov.class);
        classes.add(Clasjeraprod.class);
        classes.add(Clasjeracli.class);
        classes.add(Clasificacion.class);
        classes.add(Clasemp.class);
        classes.add(Chat.class);
        classes.add(CUsoCFDI.class);
        classes.add(GeneralConfig.class);
        classes.add(Garan.class);
        classes.add(Flujact.class);
        classes.add(Fluj.class);
        classes.add(Facturas.class);
        classes.add(Fabs.class);
        classes.add(Existalma.class);
        classes.add(Estadiscor.class);        
        classes.add(ERPermisos.class);
        classes.add(ERMmovimientosInventario.class);
        classes.add(EREjercicios.class);
        classes.add(Domentcli.class);
        classes.add(DocumentosPago.class);
        classes.add(DocumentosOrigen.class);
        classes.add(DocumentosContabilizados.class);
        classes.add(DocumentOrigin.class);
        classes.add(DeliverAddressCustomer.class);
        classes.add(Datoscp.class);
        classes.add(Cxp.class);
        classes.add(Cxc.class);        
        classes.add(Cumple.class);
        classes.add(CuentasContables.class);        
        classes.add(Cots.class);
        classes.add(Costs.class);
        classes.add(PartcomprsTmp.class);
        classes.add(Partcomprs.class);        
        classes.add(Ords.class);
        classes.add(Msjs.class);
        classes.add(MovimientosPagos.class);
        classes.add(MovimientosAsientos.class);
        classes.add(Moninven.class);
        classes.add(ModificaImpuestos.class);
        classes.add(Modelprod.class);
        classes.add(Model.class);
        classes.add(MetogoPago.class);
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
        classes.add(IngresosEncab.class);
        classes.add(Ingres.class);
        classes.add(Impuesxpartidaped.class);
        classes.add(Impuesxpartidacot.class);
        classes.add(ImpuestosXVenta.class);
        classes.add(ImpuestosXCompra.class);
        classes.add(ImpuestosVenta.class);
        classes.add(ImpuesXProduct.class);
        classes.add(HistAntiguedaddesaldo.class);
        classes.add(Grals.class);
        classes.add(Giro.class);
        classes.add(resp355834.class);
        classes.add(Zona.class);
        classes.add(Warehouse.class);        
        classes.add(Usuarioserie.class);
        classes.add(UsoCFDI.class);
        classes.add(UserPermission.class);
        classes.add(User.class);
        classes.add(Unid.class);
        classes.add(Ubiad.class);
        classes.add(Traspas.class);
        classes.add(Tipscamb.class);
        classes.add(Tips.class);
        classes.add(Tipactfij.class);
        classes.add(Terprodcompa.class);
        classes.add(Termarcamodelo.class);
        classes.add(Tax.class);
        classes.add(Tars.class);
        classes.add(Tallcolo.class);
        classes.add(Tall.class);
        classes.add(Supplier.class);
        classes.add(Sucursal.class);
        classes.add(Subramos.class);
        classes.add(ServerSession.class);
        classes.add(Serieprod.class);
        classes.add(Serie.class);
        classes.add(Sectores.class);
        classes.add(Sales.class);
        classes.add(Ruts.class);
        classes.add(Rubr.class);
        classes.add(Responsable.class);
        classes.add(Resplog.class);
        classes.add(Resp.class);
        classes.add(Registros.class);
        classes.add(Registroemail.class);
        classes.add(PushNotification.class);
        classes.add(Product.class);
        classes.add(Prodpart.class);
        classes.add(Prevcomprs.class);
        classes.add(Petis.class);
        classes.add(Pes.class);
        classes.add(Pers.class);
        classes.add(PedidosParts.class);
        classes.add(Pedidos.class);
        classes.add(PaymentForm.class);
        classes.add(Payment.class);
        classes.add(Partvta.class);
        classes.add(PartprevcomprsTmp.class);
        classes.add(Partprevcomprs.class);
        classes.add(Partords.class);
        classes.add(Partflujact.class);
        classes.add(Partcot.class);
        return classes;
    }
    
    private List<Class> getAnnottatedClassesFordbempresas() throws Exception {
        
        final List<Class> classes = new ArrayList<>();
        classes.add(BasDats.class);
        classes.add(License.class);
        classes.add(ServerSession.class);
        classes.add(CCodigopostal.class);
        classes.add(CCountry.class);
        classes.add(CRegimenfiscal.class);
        return classes;
    }
    
    public SessionFactory getSessionFactoryFromNewDatabase(final String database) throws Exception {
        
        //If the user previusly defined the connection params use them
        HibernateConfigModel HibernateConfigModel_;
        if(HibernateConfigModel != null){
            HibernateConfigModel_ = HibernateConfigModel;                        
        }
        else{                        
            HibernateConfigModel_ = HibernateConfigUtil.getInstance().getHibernateConfigFile();   
        }        
        
        //Create config file
        final AnnotationConfiguration AnnotationConfiguration = getSessionFactoryFromHibernateConfigModel(HibernateConfigModel_,"none");
        
        //Add anotated classes
        List<Class> classes = getAnnottatedClasses();
        for(Class class_:classes){
            LoggerUtility.getSingleton().logInfo(HibernateUtil.class, "Adding annotated class " + class_);
            AnnotationConfiguration.addAnnotatedClass(class_);
        }
        
        sessionFactoryAnother = AnnotationConfiguration.buildSessionFactory();
        
        return sessionFactoryAnother;
    }
    
    public void shutdown() throws Exception {
        getSessionFactory().close();
    }
    
    public void shutdownAnother() {
        // Close caches and connection pools
        sessionFactoryAnother.close();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
