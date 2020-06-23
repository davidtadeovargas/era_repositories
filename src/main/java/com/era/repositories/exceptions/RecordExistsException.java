/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories.exceptions;

/**
 *
 * @author PC
 */
public class RecordExistsException extends Exception {
    
    public RecordExistsException(){
        super("errors_record_exists");
    }
}
