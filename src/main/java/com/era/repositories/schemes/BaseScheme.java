/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories.schemes;

import org.hibernate.cfg.Configuration;

/**
 *
 * @author PC
 */
public class BaseScheme {
    
    protected Configuration Configuration;
    
    
    public BaseScheme(Configuration Configuration){
        this.Configuration = Configuration;
    }
}
