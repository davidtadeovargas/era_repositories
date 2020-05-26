/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories.utils;

import com.era.repositories.schemes.ProductScheme;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;

/**
 *
 * @author PC
 */
public class HibernateSchemeUtil {
    
    private static HibernateSchemeUtil HibernateSchemeUtil;
    
    private ProductScheme ProductScheme;
    private final Configuration Configuration;
    
    
    
    private HibernateSchemeUtil() throws Exception{        
        this.Configuration = HibernateUtil.getSingleton().getLocalAnnotationConfiguration();
    }
    
    //HibernateSchemeUtil.getSingleton().getProductScheme().getColumnLength();
    public static HibernateSchemeUtil getSingleton() throws Exception{
        if(HibernateSchemeUtil==null){
            HibernateSchemeUtil = new HibernateSchemeUtil();
        }
        return HibernateSchemeUtil;
    }
    
    public ProductScheme getProductScheme(){                
        if(ProductScheme==null){
            ProductScheme = new ProductScheme(Configuration);
        }
        return ProductScheme;
    }
    
    public static int getColumnLength(Configuration Configuration, String className, String propertyName) {
        
        PersistentClass persistentClass = Configuration.getClassMapping(className);
        Property property = persistentClass.getProperty(propertyName);
        int length = ((Column) property.getColumnIterator().next()).getLength();

        return length;
    }
    
    public List<String> getAllTableNames(final Session Session ) {
        
        final SessionFactory SessionFactory = Session.getSessionFactory();
        final List<String> names = new ArrayList<>();
        final Map m = SessionFactory.getAllClassMetadata();
        for(int x = 0; x < m.size(); x++){
            final AbstractEntityPersister aep = (AbstractEntityPersister) m.get(x); 
            String tableName = aep.getTableName();
            names.add(tableName);
        }
        return names;
    }
    
    public ClassMetadata getTableMetaData(final Session Session, final Class Class) {
        
        final SessionFactory SessionFactory = Session.getSessionFactory();
        final ClassMetadata classMetadata = SessionFactory.getClassMetadata(Class);
        return classMetadata;
    }
}
