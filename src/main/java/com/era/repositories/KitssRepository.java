package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Kits;
import com.era.repositories.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class KitssRepository extends Repository {

    public KitssRepository() {
        super(Kits.class);
    }

    public List<Kits> getComponentsByKit(final String kitCode) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Kits where code = :kitCode";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("kitCode", kitCode);
        final List<Kits> kits = query.list();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return kits;
        
    }
    
    public void deleteAllComponentsFromKit(final String codeKit) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);        
                
        SQLQuery SQLQuery = HibernateUtil.getSingleton().getSession().createSQLQuery("DELETE FROM Kits WHERE code = :codeKit");
        SQLQuery.setParameter("codeKit", codeKit);
        SQLQuery.executeUpdate();
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);        
    }
    
    public void saveComponentsToKit(final String codeKit, final List<Kits> kits) throws Exception {
        
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        //Delete all components from the kit
        deleteAllComponentsFromKit(codeKit);        
        
        if(kits!=null){
            for(Kits kit:kits){

                final String productCode = kit.getCode();
                final String componentCode = kit.getProd();

                //Get the kit
                final Kits Kit = getByKitAndComponent(productCode, componentCode);

                //Save it or update ir
                if(Kit==null){
                    this.save(kit);
                }
                else{
                    this.update(kit);
                }
            }
        }
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
    }
    
    final public Kits getByKitAndComponent(final String codeKit, final String componentCode) throws Exception {
    
        //Open database
        HibernateUtil.getSingleton().openSession(ClassEntity);
        
        String hql = "FROM Kits where code = :codeKit AND prod = :componentCode";
        Query query = HibernateUtil.getSingleton().getSession().createQuery(hql);
        query.setParameter("codeKit", codeKit);
        query.setParameter("componentCode", componentCode);
        final  Kits Kits = query.list().size() > 0 ? (Kits)query.list().get(0):null;
        
        //Close database        
        HibernateUtil.getSingleton().closeSession(ClassEntity);
        
        //Return the result model
        return Kits;
    }
    
    @Override
    final public List<Kits> getByLikeEncabezados(final String search) throws Exception{
        
       final List<String> likes = new ArrayList<>();
       likes.add("falt");
       likes.add("fmod");
       
       final List<Kits> records = (List<Kits>) this.getAllLike(likes, search);
       
       return records;
    }

}