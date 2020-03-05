/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories.utils;

import com.era.repositories.schemes.ProductScheme;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;

/**
 *
 * @author PC
 */
public class HibernateSchemeUtil {
    
    private static HibernateSchemeUtil HibernateSchemeUtil;
    
    private ProductScheme ProductScheme;
    private final Configuration Configuration;
    
    
    
    private HibernateSchemeUtil() throws Exception{        
        this.Configuration = HibernateUtil.getSingleton().getAnnotationConfiguration();
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
}
