/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.CCoin;

/**
 *
 * @author PC
 */
public class CCoinRepository extends Repository {
    
    protected CCoinRepository(){
        super(CCoin.class);
    }
}