package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Existalma;
import com.era.models.User;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;

public class ExistalmasRepository extends Repository {

   public ExistalmasRepository() {
        super(Existalma.class);
   }

   final public void updateExistences(final String warehouseCode, final String productCode, final double existence) throws Exception {
       
       //If the record not exists create it
       Existalma Existalma = getByWarehouseAndProduct(warehouseCode, productCode);
       if(Existalma==null){
            Existalma = new Existalma();
            Existalma.setAlma(warehouseCode);
            Existalma.setProd(productCode);
            Existalma.setExist((float)existence);
            this.save(Existalma);
       }
       else{
           Existalma.setExist((float)existence);
           this.update(Existalma);
       }
   }
   
   final public Existalma getByWarehouseAndProduct(final String warehouseCode, final String productCode) throws Exception {
       
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Existalma where alma = :warehouseCode AND prod = :productCode";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("warehouseCode", warehouseCode);
        query.setParameter("productCode", productCode);
        Existalma Existalma = query.list().size() > 0 ? (Existalma)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Existalma;
   }
   
   @Override
   final public List<Existalma> getByLikeEncabezados(final String search) throws Exception {
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Existalma> records = (List<Existalma>) this.getAllLike(likes, search);
       
       return records;
   }
}