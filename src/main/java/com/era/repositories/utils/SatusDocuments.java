/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories.utils;

/**
 *
 * @author PC
 */
public class SatusDocuments {
    
    private static SatusDocuments SatusDocuments;
    
    
    private SatusDocuments(){
        
    }
    
    
    public static SatusDocuments getSingleton(){
        if(SatusDocuments==null){
            SatusDocuments = new SatusDocuments();
        }
        return SatusDocuments;
    }
    
    public boolean isConfirmed(final String estatus) {
        return estatus.equals("CO");
    }
    public boolean isCanceled(final String estatus) {
        return estatus.equals("CA");
    }
    public boolean isDevolution(final String estatus) {
        return estatus.equals("DEV");
    }
    public boolean isPDevolution(final String estatus) {
        return estatus.equals("DEVP");
    }
    public boolean isPending(final String estatus) {
        return estatus.equals("PE");
    }
    
    public String getConfirmedEstate() {
        return "CO";
    }
    public String getPendingEstate() {
        return "PE";
    }
    public String getCanceledEstate() {
        return "CA";
    }
    public String getDevolutionEstate() {
        return "DEV";
    }
    public String getPartialDevolutionEstate() {
        return "PDEV";
    }
}
