/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories;

import com.era.models.Line;

/**
 *
 * @author PC
 */
public class LinesRepository extends Repository {
    
    protected LinesRepository(){
        super(Line.class);
    }
}