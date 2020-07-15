package com.era.repositories;

import com.era.models.Coin;
import com.era.models.Company;
import com.era.models.Cxc;
import com.era.models.Fluj;
import com.era.models.Kits;
import com.era.models.Partvta;
import com.era.models.Product;
import com.era.models.Sales;
import com.era.models.Tips;
import com.era.repositories.utils.HibernateUtil;
import com.era.utilities.UtilitiesFactory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
    
    final public void saveSale(final Sales Sale, final Company Company, final boolean updateCustomerInfo, final List<Partvta> parts, final BigDecimal totalCash, final BigDecimal totalCardDebit, final BigDecimal totalCardCredit) throws Exception {
        
        HibernateUtil.getSingleton().openSessionInTransacction(ClassEntity);
        
        //Save the new sale
        final Sales Sale_ = (Sales)this.save(Sale);
        
        //If the customer will pay in credit verify that really can do it
        if(Sale.isCredit()){
            
            //If the customer doesnt have credit stop
            if(!Company.hasCredit()){
                UtilitiesFactory.getSingleton().getGenericExceptionUtil().generateException("errors_customer_with_no_available_credit");
                return;
            }
                        
            //Get positive sald of the customer
            final BigDecimal favorSald = RepositoryFactory.getInstance().getCxcRepository().getSaldoFavorFromCustomer(Company.getCompanyCode());

            //If the customer doesnt have money credit avaible
            if(favorSald.compareTo(Company.getLimtcred())<0){            
                UtilitiesFactory.getSingleton().getGenericExceptionUtil().generateException("errors_customer_with_no_sald_for_credit");
                return;
            }
            
            //Get the date for payment
            final Date Date_ = UtilitiesFactory.getSingleton().getDateTimeUtility().getDatePlusDays(Company.getDiacred());
            
            final Coin Coin = (Coin)RepositoryFactory.getInstance().getCoinsRepository().getByCode(Sale_.getCoinCode());
            
            //Create the model
            final Cxc Cxc = new Cxc();
            Cxc.setNorefer(Sale_.getReferenceNumber());
            Cxc.setNoser(Sale_.getNoser());
            Cxc.setEmpre(Company.getCompanyCode());
            Cxc.setFormpag(Sale_.getPaymentForm());
            Cxc.setConceppag("");
            Cxc.setSer("");
            Cxc.setSubtot(Sale_.getSubtotal());
            Cxc.setImpue(Sale_.getTax());
            Cxc.setTot(Sale_.getTotal());
            Cxc.setAbon(BigDecimal.ZERO);
            Cxc.setCarg(Sale_.getTotal());
            Cxc.setComen("");
            Cxc.setConcep("");
            Cxc.setFolbanc("");
            Cxc.setFvenc(Date_);
            Cxc.setFdoc(UtilitiesFactory.getSingleton().getDateTimeUtility().getCurrentDate());
            Cxc.setFol(0);
            Cxc.setCuentabanco("");
            Cxc.setId_venta(Sale_.getId());
            Cxc.setMonedaID(Coin.getId());
            
            //Insert in cxc
            RepositoryFactory.getInstance().getCxcRepository().save(Cxc);
        }
        
        //If the user wants to update the customer info
        if(updateCustomerInfo){

            RepositoryFactory.getInstance().getCompanysRepository().update(Company);
        }

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
        
        //Save cash payment
        if(totalCash.doubleValue()>0){
            
            Fluj Fluj = new Fluj();
            Fluj.setImpo(totalCash);
            Fluj.setVta(Sale_.getId());
            Fluj.setTipdoc(Sale_.getDocumentType());        
            Fluj.setMon(Sale_.getCoinCode());
            Fluj.setNorefer(Sale_.getReferenceNumber());
            RepositoryFactory.getInstance().getFlujsRepository().saveEnt(Fluj,FlujsRepository.TypePayment.CASH);
        }
        
        //Save card debit payment
        if(totalCardDebit.doubleValue()>0){
            
            Fluj Fluj = new Fluj();
            Fluj.setImpo(totalCardDebit);
            Fluj.setVta(Sale_.getId());
            Fluj.setTipdoc(Sale_.getDocumentType());        
            Fluj.setMon(Sale_.getCoinCode());
            Fluj.setNorefer(Sale_.getReferenceNumber());
            RepositoryFactory.getInstance().getFlujsRepository().saveEnt(Fluj,FlujsRepository.TypePayment.CARD_DEBIT);
        }
        
        //Save card debit payment
        if(totalCardCredit.doubleValue()>0){
            
            Fluj Fluj = new Fluj();
            Fluj.setImpo(totalCardCredit);
            Fluj.setVta(Sale_.getId());
            Fluj.setTipdoc(Sale_.getDocumentType());        
            Fluj.setMon(Sale_.getCoinCode());
            Fluj.setNorefer(Sale_.getReferenceNumber());
            RepositoryFactory.getInstance().getFlujsRepository().saveEnt(Fluj,FlujsRepository.TypePayment.CARD_CREDIT);
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
                for(int x = 0; x < Partvta.getCant().intValue(); x++){
                    for(Kits Kit: kits){
                        RepositoryFactory.getInstance().getExistalmasRepository().addExistenceToWarehouse(Kit.getProd(), Partvta.getAlma(), Partvta.getUnid(), Kit.getCant(), ConcepssRepository.TYPES.CANVENTA);
                    }
                }
            }
            else{ //Not kit affect inventory normally
                RepositoryFactory.getInstance().getExistalmasRepository().addExistenceToWarehouse(Partvta.getProd(), Partvta.getAlma(), Partvta.getUnid(), Partvta.getCant().floatValue(), ConcepssRepository.TYPES.CANVENTA);
            }
        }
        
        HibernateUtil.getSingleton().closeSessionInTransaction(ClassEntity);
    }
    
    final public void returnSale(final int saleID, final String motiv) throws Exception {
        
        HibernateUtil.getSingleton().openSessionInTransacction(ClassEntity);
        
        //Get the sale
        Sales Sale = (Sales)this.getByID(saleID);
        
        //Return it
        Sale.setEstatus("DEV");
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
                    RepositoryFactory.getInstance().getExistalmasRepository().addExistenceToWarehouse(Kit.getProd(), Partvta.getAlma(), Partvta.getUnid(), Kit.getCant(), ConcepssRepository.TYPES.DEVVENTA);
                }
            }
            else{ //Not kit affect inventory normally
                RepositoryFactory.getInstance().getExistalmasRepository().addExistenceToWarehouse(Partvta.getProd(), Partvta.getAlma(), Partvta.getUnid(), Partvta.getCant().floatValue(), ConcepssRepository.TYPES.DEVVENTA);
            }
        }
        
        HibernateUtil.getSingleton().closeSessionInTransaction(ClassEntity);
    }
    
    final public String getConfirmedSaleStatus(){
        return "CO";
    }
    
    final public void returnPartialSale(final int saleID, final String motiv, final List<Partvta> items) throws Exception {
        
        HibernateUtil.getSingleton().openSessionInTransacction(ClassEntity);                
        
        //Loop all to affect inventories
        boolean allDevsComplete = true;
        for(Partvta Partvta:items){
            
            //Get the total to devolution
            final BigDecimal toDevs = Partvta.getToDevs();
            final BigDecimal devs = Partvta.getDevs();
            final BigDecimal totalDevs = devs.add(toDevs);
            final BigDecimal cant = Partvta.getCant();
            
            //If is kit affect inventory by components
            if(Partvta.isEskit()){
                
                //Get all the componentes
                final List<Kits> kits = RepositoryFactory.getInstance().getKitssRepository().getComponentsByKit(Partvta.getProd());
                
                //Affect invetory for each component of the kit
                for(int x = 0; x < toDevs.intValue(); x++){
                    for(Kits Kit: kits){
                        RepositoryFactory.getInstance().getExistalmasRepository().addExistenceToWarehouse(Kit.getProd(), Partvta.getAlma(), Partvta.getUnid(), Kit.getCant(), ConcepssRepository.TYPES.DEVPVENTA);
                    }
                }
            }
            else{ //Not kit affect inventory normally
                RepositoryFactory.getInstance().getExistalmasRepository().addExistenceToWarehouse(Partvta.getProd(), Partvta.getAlma(), Partvta.getUnid(), toDevs.floatValue(), ConcepssRepository.TYPES.DEVPVENTA);
            }
            
            if(totalDevs.compareTo(cant)!=0){
                allDevsComplete = false;
            }
        }
        
        //Get the sale
        Sales Sale = (Sales)this.getByID(saleID);
                                
        if(allDevsComplete){
            Sale.setEstatus("DEV");
        }
        else{
            Sale.setEstatus("PDEV");
        }
        
        //Update the sale
        Sale.setRazon(motiv);
        this.update(Sale);
        
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
    
    final public CortZXData getTotalsForCortXZ() throws Exception {
        
        //Get all the sales from the point of sale
        final List<Sales> sales = this.getAllConfirmedSalesFromPointOfSales();
        
        final CortZXData CortZXData = new CortZXData();
        CortZXData.setSubtotal(BigDecimal.ZERO);
        CortZXData.setDisccount(BigDecimal.ZERO);
        CortZXData.setTaxes(BigDecimal.ZERO);
        CortZXData.setTotal(BigDecimal.ZERO);        
        CortZXData.setTotalImportTickets(BigDecimal.TEN);
        CortZXData.setTotalImportRems(BigDecimal.ZERO);
        CortZXData.setTotalImportFactus(BigDecimal.ZERO);
        CortZXData.setSales(sales);
        CortZXData.setTotalImportDevs(BigDecimal.ZERO);
        
        int totalSalesDevs = 0;
        int totalSales = 0;
        int totalTickets = 0;
        int totalFactus = 0;
        int totalRems = 0;
        
        //Loop all the sales
        for(Sales Sale:sales){
            
            final BigDecimal subtotal = Sale.getSubtotal();
            final BigDecimal disccount = Sale.getTotalDisccount();
            final BigDecimal taxes = Sale.getTotalRetention().add(Sale.getTotalTranslade());
            final BigDecimal total = Sale.getTotal();
            
            CortZXData.setSubtotal(CortZXData.getSubtotal().add(subtotal));
            CortZXData.setDisccount(CortZXData.getDisccount().add(disccount));
            CortZXData.setTaxes(CortZXData.getTaxes().add(taxes));
            CortZXData.setTotal(CortZXData.getTotal().add(total));
            
            if(Sale.isDev()){
                ++totalSalesDevs;
                CortZXData.setTotalImportDevs(CortZXData.getTotalImportDevs().add(total));                
            }
            
            if(Sale.isTicket()){
                ++totalTickets;
                CortZXData.setTotalImportTickets(CortZXData.getTotalImportTickets().add(total));
            }
            else if(Sale.isFacturado()){
                ++totalFactus;
                CortZXData.setTotalImportFactus(CortZXData.getTotalImportFactus().add(total));
            }
            else {
                ++totalRems;
                CortZXData.setTotalImportRems(CortZXData.getTotalImportRems().add(total));
            }
            
            ++totalSales;
        }
        
        final BigDecimal totalCashPayment = RepositoryFactory.getInstance().getFlujsRepository().getTotalSalesPendingCortInCash();
        final BigDecimal totalCardDebitPayment = RepositoryFactory.getInstance().getFlujsRepository().getTotalSalesPendingCortInCardDebit();
        final BigDecimal totalCardCreditPayment = RepositoryFactory.getInstance().getFlujsRepository().getTotalSalesPendingCortInCardCredit();
        final BigDecimal totalExistenceMoneyInCasher = RepositoryFactory.getInstance().getFlujsRepository().getTotalExistenceMoneyInCasher();
                                        
        CortZXData.setTotalCashPayment(totalCashPayment);
        CortZXData.setTotalCardDebitPayment(totalCardDebitPayment);
        CortZXData.setTotalCardCreditPayment(totalCardCreditPayment);
        CortZXData.setTotalExistenceMoneyInCasher(totalExistenceMoneyInCasher);
        
        CortZXData.setTotalSalesDevs(totalSalesDevs);
        CortZXData.setTotalSales(totalSales);
        
        CortZXData.setTotalTickets(totalTickets);
        CortZXData.setTotalFactus(totalFactus);
        CortZXData.setTotalRems(totalRems);
        
        //Return the totas
        return CortZXData;
    }
    
    public class CortZXData {
        
        private BigDecimal subtotal;
        private BigDecimal disccount;
        private BigDecimal taxes;
        private BigDecimal total;
        private BigDecimal totalImportDevs;
        
        private BigDecimal totalCashPayment;
        private BigDecimal totalCardDebitPayment;
        private BigDecimal totalCardCreditPayment;
        private BigDecimal totalExistenceMoneyInCasher;        
        
        private BigDecimal totalImportTickets;
        private BigDecimal totalImportFactus;
        private BigDecimal totalImportRems;
        
        private int totalSalesDevs;
        private int totalSales;
        private int totalTickets;
        private int totalFactus;
        private int totalRems;

        private List<Sales> sales;
        
        public BigDecimal getSubtotal() {
            return subtotal;
        }

        public BigDecimal getTotalExistenceMoneyInCasher() {
            return totalExistenceMoneyInCasher;
        }

        public void setTotalExistenceMoneyInCasher(BigDecimal totalExistenceMoneyInCasher) {
            this.totalExistenceMoneyInCasher = totalExistenceMoneyInCasher;
        }
        
        public BigDecimal getTotalCashPayment() {
            return totalCashPayment;
        }

        public void setTotalCashPayment(BigDecimal totalCashPayment) {
            this.totalCashPayment = totalCashPayment;
        }

        public BigDecimal getTotalCardDebitPayment() {
            return totalCardDebitPayment;
        }

        public void setTotalCardDebitPayment(BigDecimal totalCardDebitPayment) {
            this.totalCardDebitPayment = totalCardDebitPayment;
        }

        public BigDecimal getTotalCardCreditPayment() {
            return totalCardCreditPayment;
        }

        public void setTotalCardCreditPayment(BigDecimal totalCardCreditPayment) {
            this.totalCardCreditPayment = totalCardCreditPayment;
        }
        
        public List<Sales> getSales() {
            return sales;
        }

        public void setSales(List<Sales> sales) {
            this.sales = sales;
        }
        
        public BigDecimal getTotalImportTickets() {
            return totalImportTickets;
        }

        public void setTotalImportTickets(BigDecimal totalImportTickets) {
            this.totalImportTickets = totalImportTickets;
        }

        public BigDecimal getTotalImportDevs() {
            return totalImportDevs;
        }

        public void setTotalImportDevs(BigDecimal totalImportDevs) {
            this.totalImportDevs = totalImportDevs;
        }
        
        public BigDecimal getTotalImportFactus() {
            return totalImportFactus;
        }

        public void setTotalImportFactus(BigDecimal totalImportFactus) {
            this.totalImportFactus = totalImportFactus;
        }

        public BigDecimal getTotalImportRems() {
            return totalImportRems;
        }

        public void setTotalImportRems(BigDecimal totalImportRems) {
            this.totalImportRems = totalImportRems;
        }
        
        public int getTotalTickets() {
            return totalTickets;
        }

        public void setTotalTickets(int totalTickets) {
            this.totalTickets = totalTickets;
        }

        public int getTotalFactus() {
            return totalFactus;
        }

        public void setTotalFactus(int totalFactus) {
            this.totalFactus = totalFactus;
        }

        public int getTotalRems() {
            return totalRems;
        }

        public void setTotalRems(int totalRems) {
            this.totalRems = totalRems;
        }
        
        public int getTotalSales() {
            return totalSales;
        }

        public void setTotalSales(int totalSales) {
            this.totalSales = totalSales;
        }
        
        public int getTotalSalesDevs() {
            return totalSalesDevs;
        }

        public void setTotalSalesDevs(int totalSalesDevs) {
            this.totalSalesDevs = totalSalesDevs;
        }
        
        public void setSubtotal(BigDecimal subtotal) {
            this.subtotal = subtotal;
        }

        public BigDecimal getDisccount() {
            return disccount;
        }

        public void setDisccount(BigDecimal disccount) {
            this.disccount = disccount;
        }

        public BigDecimal getTaxes() {
            return taxes;
        }

        public void setTaxes(BigDecimal taxes) {
            this.taxes = taxes;
        }

        public BigDecimal getTotal() {
            return total;
        }

        public void setTotal(BigDecimal total) {
            this.total = total;
        }
    }
    
    final public void updateAllSalesAsCutS() throws Exception {
        this.updateSQL("UPDATE vtas SET cort = 'S' WHERE cort = 'N'");
    }
    
    final public List<Sales> getAllConfirmedSalesFromPointOfSales() throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(this.ClassEntity);        
                
        String hql = "FROM Sales WHERE estatus = :estatus AND salesPoint = :salesPoint AND cut = 'N'";
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