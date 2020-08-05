package com.era.repositories;

import com.era.models.ImpuesXProduct;
import java.util.List;
import java.util.ArrayList;
import com.era.models.ImpuestosXVenta;
import com.era.models.Tax;
import com.era.repositories.utils.HibernateUtil;
import java.math.BigDecimal;
import java.math.MathContext;
import org.hibernate.Query;
import org.hibernate.Session;

public class ImpuestosXVentasRepository extends Repository {

    public ImpuestosXVentasRepository() {
        super(ImpuestosXVenta.class);
    }

    public void saveProductTaxes(final int saleID, final int partID, final BigDecimal qty, final BigDecimal price, List<ImpuesXProduct> taxesProduct) throws Exception {
    
        //Save all the taxes
        for(ImpuesXProduct ImpuesXProduct_:taxesProduct){
        
            Tax Tax = (Tax)RepositoryFactory.getInstance().getTaxesRepository().getByCode(ImpuesXProduct_.getImpue());
            
            final ImpuestosXVenta ImpuestosXVenta = new ImpuestosXVenta();
            ImpuestosXVenta.setId_partida(partID);
            ImpuestosXVenta.setImpuesto(ImpuesXProduct_.getImpue());
            ImpuestosXVenta.setRetencion(Tax.isRetention());            
                        
            final BigDecimal taxValue  = new BigDecimal(Tax.getValue() / 100, MathContext.DECIMAL64);;
            final BigDecimal totalTax = taxValue.multiply(price).multiply(qty);
            
            ImpuestosXVenta.setTotal(totalTax);
            
            this.save(ImpuestosXVenta);
        }
    }
    
    public List<ImpuestosXVenta> getAllBySaleId(final int saleID) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);       
        
        final Session Session = HibernateUtil.getSingleton().getSession();
        
        String hql = "FROM ImpuestosXVenta WHERE venta :saleID";
        Query query = Session.createQuery(hql);
        query.setParameter("saleID", saleID);        
        List<ImpuestosXVenta> records = query.list();
        
        //Close database
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return records;
    }
    
    @Override
    final public List<ImpuestosXVenta> getByLikeEncabezados(final String search) throws Exception{

        final List<String> likes = new ArrayList<>();
        likes.add("falt");
        likes.add("fmod");

        final List<ImpuestosXVenta> records = (List<ImpuestosXVenta>) this.getAllLike(likes, search);

        return records;
    }
}