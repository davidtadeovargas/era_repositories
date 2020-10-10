package com.era.repositories;

import com.era.models.Cxc;
import java.util.List;
import java.util.ArrayList;
import com.era.models.Payment;
import com.era.repositories.utils.HibernateUtil;
import java.math.BigDecimal;
import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.classic.Session;

public class PaymentsRepository extends Repository {

    public PaymentsRepository() {
        super(Payment.class);
    }

        
    public Object save(final Cxc Cxc, final Payment Payment) throws Exception {

        final BigDecimal totalPaid = RepositoryFactory.getInstance().getPaymentsRepository().getTotalPaidForDocument(Cxc.getNoser(),Cxc.getNorefer());
        final BigDecimal pendingToPay = Cxc.getCarg().subtract(totalPaid==null?BigDecimal.ZERO:totalPaid).subtract(Payment.getImporte());
            
        final long transactionId_ = HibernateUtil.getSingleton().openSessionInTransacction(ClassEntity);
        
        Payment.setEstatus("CO");
        
        //Save the payment
        final Payment Payment_ = (Payment)this.save(Payment);
        
        //If the CXC is already paid
        if(pendingToPay.compareTo(BigDecimal.ZERO)==0){
            RepositoryFactory.getInstance().getCxcRepository().confirmCXC(Cxc.getId());
        }
        
        HibernateUtil.getSingleton().closeSession(ClassEntity,transactionId_);
        
        return Payment_;
    }
    
    public Object cancel(final Payment Payment) throws Exception {

        Payment.setEstatus("CA");
        
        //Save the payment
        final Payment Payment_ = (Payment)this.update(Payment);
        
        return Payment_;
    }
    
    final public boolean isConfirmed(final Payment Payment){
        return Payment.getEstatus().compareTo("CO")==0;
    }
    
    final public List<Payment> getAllPaymentsOfDocument(final String folio, final String serie) throws Exception {
        
        //Open database
        openDatabase();
        
        String hql = "FROM Payment where folio = :folio AND serie = :serie";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("folio", folio);
        query.setParameter("serie", serie);        
        List<Payment> payments = query.list();
        
        //Close database        
        closeDatabase();
        
        //Return the result model
        return payments;
    }
        
    final public BigDecimal getTotalPaidForDocument(final String serie, final String folio) throws Exception {
        
        //Open database
        openDatabase();
        
        String hql = "select sum(importe) from Payment where serie = :serie AND folio = :folio AND estatus = :estatus";
        final Session Session = HibernateUtil.getSingleton().getSession();
        Query query = Session.createQuery(hql);
        query.setParameter("serie", serie);
        query.setParameter("folio", folio);
        query.setParameter("estatus", "CO");
        Iterator count = query.iterate();
        
        final BigDecimal sum = (BigDecimal) count.next();
        
        //Close database
        closeDatabase();
        
        //Return the result model
        return sum;
    }
    
    @Override
    final public List<Payment> getByLikeEncabezados(final String search) throws Exception{

        final List<String> likes = new ArrayList<>();
        likes.add("falt");
        likes.add("fmod");

        final List<Payment> records = (List<Payment>) this.getAllLike(likes, search);

        return records;
    }

}