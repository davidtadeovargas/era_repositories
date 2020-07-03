package com.era.repositories;

import com.era.models.Kits;
import com.era.models.Partvta;
import com.era.models.Product;
import com.era.models.Sales;
import com.era.models.Tips;
import com.era.repositories.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.classic.Session;

public class SalessRepository extends Repository {

   public SalessRepository() {
        super(Sales.class);
    }
   
   final public int getTotalSalesFromCustomer(final String codemp) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(this.ClassEntity);
        
        String hql = "select count(*) from Sales where codemp = :codemp";
        final Session Session = HibernateUtil.getSingleton().getSession();
        Query query = Session.createQuery(hql);
        query.setParameter("codemp", codemp);
        Iterator count = query.iterate();
        
        //Close database
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return (int) count.next();
    }
    
    final public Sales getByNotCred(final String notcred) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(this.ClassEntity);
        HibernateUtil.getSingleton().begginTransaction();
        
        
        String hql = "FROM Sales where notcred = :notcred";
        final Session Session = HibernateUtil.getSingleton().getSession();
        Query query = Session.createQuery(hql);
        query.setParameter("notcred", notcred);
        Sales Sales = query.list().size() > 0 ? (Sales)query.list().get(0):null;
        
        //Close database
        HibernateUtil.getSingleton().commitTransacton();
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Sales;
    }
    
    final public Sales getByVentaRef(final String vtaRef) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(this.ClassEntity);
        HibernateUtil.getSingleton().begginTransaction();        
        
        String hql = "FROM Sales where vtaRef = :vtaRef";
        final Session Session = HibernateUtil.getSingleton().getSession();
        Query query = Session.createQuery(hql);
        query.setParameter("vtaRef", vtaRef);
        Sales Sales = query.list().size() > 0 ? (Sales)query.list().get(0):null;
        
        //Close database
        HibernateUtil.getSingleton().commitTransacton();
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Sales;
    }
    
    final public void saveSale(final Sales Sale, final List<Partvta> parts) throws Exception {
        
        HibernateUtil.getSingleton().openSessionInTransacction(ClassEntity);
        
        //Save the new sale
        final Sales Sale_ = (Sales)this.save(Sale);
        
        //Save the rows
        for(Partvta Partvta: parts){
            Partvta.setVta(Sale_.getId());
            
            //If the product is kit
            if(Partvta.isEskit()){
                                
                //Get all the components of the kit
                final List<Kits> kits = RepositoryFactory.getInstance().getKitssRepository().getComponentsByKit(Partvta.getProd());
                
                //Affect invetory for each element of the kit
                for(Kits Kit:kits){
                    
                    //Get the product
                    final Product KitProduct = (Product)RepositoryFactory.getInstance().getProductsRepository().getByCode(Kit.getProd());
                    
                    //Affect inventory
                    RepositoryFactory.getInstance().getExistalmasRepository().removeExistenceToWarehouse(Kit.getProd(), Partvta.getAlma(), KitProduct.getUnit(), Kit.getCant(), ConcepssRepository.TYPES.VENTA);
                }
            }
            else{ //Not a kit so affect inventory normally
                RepositoryFactory.getInstance().getExistalmasRepository().removeExistenceToWarehouse(Partvta.getProd(), Partvta.getAlma(), Partvta.getUnid(), Partvta.getCant().floatValue(), ConcepssRepository.TYPES.VENTA);
            }
            
            this.save(Partvta);
        }
        
        HibernateUtil.getSingleton().closeSessionInTransaction(ClassEntity);
    }
    
    final public void cancelSale(final int saleID, final String motiv) throws Exception {
        
        HibernateUtil.getSingleton().openSessionInTransacction(ClassEntity);
        
        //Get the sale
        Sales Sale = (Sales)this.getByID(saleID);
        
        //Cancel it
        Sale.setEstatus("CA");
        Sale.setRazon(motiv);        
        this.update(Sale);
        
        //Get all items of the sale
        final List<Partvta> items = RepositoryFactory.getInstance().getPartvtaRepository().getPartsVta(saleID);
        
        //Loop all to affect inventories
        for(Partvta Partvta:items){
            
            //If is kit affect inventory by components
            if(Partvta.isEskit()){
                
                //Get all the componentes
                final List<Kits> kits = RepositoryFactory.getInstance().getKitssRepository().getComponentsByKit(Partvta.getProd());
                
                //Affect invetory for each component of the kit
                for(Kits Kit: kits){
                    RepositoryFactory.getInstance().getExistalmasRepository().addExistenceToWarehouse(Kit.getProd(), Partvta.getAlma(), Partvta.getUnid(), Kit.getCant(), ConcepssRepository.TYPES.CANVENTA);
                }
            }
            else{ //Not kit affect inventory normally
                RepositoryFactory.getInstance().getExistalmasRepository().addExistenceToWarehouse(Partvta.getProd(), Partvta.getAlma(), Partvta.getUnid(), Partvta.getCant().floatValue(), ConcepssRepository.TYPES.CANVENTA);
            }
        }
        
        HibernateUtil.getSingleton().closeSessionInTransaction(ClassEntity);
    }
    
    final public List<Sales> getAllNotsCred() throws Exception {
        
        final Tips Tips = RepositoryFactory.getInstance().getTipssRepository().getFacType();
        
        //Open database
        HibernateUtil.getSingleton().openSession(this.ClassEntity);
        HibernateUtil.getSingleton().begginTransaction();
                
        String hql = "FROM Sales where tipdoc = :tipdoc";
        final Session Session = HibernateUtil.getSingleton().getSession();
        Query query = Session.createQuery(hql);
        query.setParameter("tipdoc", Tips.getCode());
        List<Sales> Sales = query.list();
        
        //Close database
        HibernateUtil.getSingleton().commitTransacton();
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Sales;
    }
    
    final public List<Sales> getAllConfirmedSales() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(this.ClassEntity);        
                
        String hql = "FROM Sales WHERE estatus = :estatus";
        final Session Session = HibernateUtil.getSingleton().getSession();
        Query query = Session.createQuery(hql);
        query.setParameter("estatus", "CO");
        List<Sales> Sales = query.list();
        
        //Close database
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Sales;
    }
    
    final public List<Sales> getAllConfirmedSalesFromPointOfSales() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(this.ClassEntity);        
                
        String hql = "FROM Sales WHERE estatus = :estatus AND salesPoint = :salesPoint";
        final Session Session = HibernateUtil.getSingleton().getSession();
        Query query = Session.createQuery(hql);
        query.setParameter("estatus", "CO");
        query.setParameter("salesPoint", true);
        List<Sales> Sales = query.list();
        
        //Close database
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Sales;
    }
    
    final public List<Sales> getAllCortXZSales() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(this.ClassEntity);        
                
        String hql = "FROM Sales WHERE estatus = :estatus AND salesPoint = :salesPoint AND facturado = :facturado AND cut = :cut AND (documentType = :documentType1 OR documentType = :documentType2 OR documentType = :documentType3)";
        final Session Session = HibernateUtil.getSingleton().getSession();
        Query query = Session.createQuery(hql);
        query.setParameter("estatus", "CO");
        query.setParameter("salesPoint", true);
        query.setParameter("facturado", false);
        query.setParameter("cut", "N");
        query.setParameter("documentType1", "FAC");
        query.setParameter("documentType2", "REM");
        query.setParameter("documentType3", "TIK");
        
        List<Sales> Sales = query.list();
        
        //Close database
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Sales;
    }
    
    final public Sales getByVenta(final int vta) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(this.ClassEntity);
        HibernateUtil.getSingleton().begginTransaction();
        
        String hql = "FROM Sales where vta = :vta";
        final Session Session = HibernateUtil.getSingleton().getSession();
        Query query = Session.createQuery(hql);
        query.setParameter("vta", vta);
        Sales Sales = query.list().size() > 0 ? (Sales)query.list().get(0):null;
        
        //Close database
        HibernateUtil.getSingleton().commitTransacton();
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Sales;
    }
    
    final public Sales getLastSale() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(this.ClassEntity);
        HibernateUtil.getSingleton().begginTransaction();
        
        String hql = "FROM Sales ORDER BY vta DESC";
        final Session Session = HibernateUtil.getSingleton().getSession();
        Query query = Session.createQuery(hql);        
        query.setMaxResults(1);
        Sales Sales = query.list().size() > 0 ? (Sales)query.list().get(0):null;
        
        //Close database
        HibernateUtil.getSingleton().commitTransacton();
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Sales;
    }
    
    final public void actualizaVentaTimbrado(   final String transid,
                                                final String sell,
                                                final String certsat,
                                                final String lugexp,
                                                final String regfisc,
                                                final String sellsat,
                                                final String cadori,
                                                final String folfisc,
                                                final int vta) throws Exception {
        
        

        final Sales Sales = this.getByVenta(vta);
        Sales.setInvoiced(true);
        Sales.setTransactionID(transid);        
        Sales.setSell(sell);
        Sales.setSellsat(sellsat);
        Sales.setCadori(cadori);
        Sales.setFiscalFolio(folfisc);
        
        this.update(Sales);
    }
    
    
    final public void liberaRemisiones(final int vta) throws Exception{
        this.update("UPDATE Sales SET estatus = 'PE', vtaRef = 0 WHERE vtaRef = " + vta);
    }
    
    
    final public void confirmaVentaOrigen(final int venta_origen) throws Exception{
        this.update("UPDATE Sales SET estatus = 'CO', venta_origen = 0, factu = 0 WHERE venta_origen = " + venta_origen);
    }
    
    @Override
    final public List<Sales> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("vta");
        likes.add("norefer");
        likes.add("salesMan");
        likes.add("tipdoc");
        likes.add("codemp");
        likes.add("falt");
        likes.add("fmod");
        
        final List<Sales> items = (List<Sales>) this.getAllLike(likes, search);
        
        return items;
    }
}