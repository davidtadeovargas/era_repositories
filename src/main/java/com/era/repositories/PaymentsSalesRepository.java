package com.era.repositories;

import com.era.models.PaymentsSale;
import java.util.ArrayList;
import java.util.List;

public class PaymentsSalesRepository extends Repository {

    public PaymentsSalesRepository() {
        super(PaymentsSale.class);
    }       
    
    public PaymentsSale saveCash(PaymentsSale PaymentsSale) throws Exception {
        
        PaymentsSale.setPaymentMethod("EFE");
        
        return (PaymentsSale)this.save(PaymentsSale);
    }
    
    public PaymentsSale saveCardDebit(PaymentsSale PaymentsSale) throws Exception {
        
        PaymentsSale.setPaymentMethod("CARDDEB");
        
        return (PaymentsSale)this.save(PaymentsSale);
    }
    
    public PaymentsSale saveCardCredit(PaymentsSale PaymentsSale) throws Exception {
        
        PaymentsSale.setPaymentMethod("CARDCRED");
        
        return (PaymentsSale)this.save(PaymentsSale);
    }
    
    @Override
    final public List<PaymentsSale> getByLikeEncabezados(final String search) throws Exception{
        
        final List<String> likes = new ArrayList<>();
        likes.add("vta");
        likes.add("payment_method");
        likes.add("falt");
        likes.add("fmod");
        
        final List<PaymentsSale> records = (List<PaymentsSale>) this.getAllLike(likes, search);
        
        return records;
    }
}