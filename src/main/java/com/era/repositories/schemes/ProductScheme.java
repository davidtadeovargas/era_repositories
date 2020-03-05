/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories.schemes;

import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;

/**
 *
 * @author PC
 */
public class ProductScheme extends BaseScheme {
        
    public ProductScheme(Configuration Configuration){
        super(Configuration);        
    }
    
    public int getDescripColumnLength() {
                        
        Configuration.buildMappings();
        PersistentClass persistentClass = Configuration.getClassMapping("com.era.models.Product");
        Property property = persistentClass.getProperty("description");
        int length = ((Column) property.getColumnIterator().next()).getLength();
        return length;
    }
}
