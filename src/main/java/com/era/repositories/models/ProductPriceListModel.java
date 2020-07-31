/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories.models;

/**
 *
 * @author PC
 */
public class ProductPriceListModel{
        
        private int priceList;
        private float price;
        private String productCode;

        public int getPriceList() {
            return priceList;
        }

        public void setPriceList(int priceList) {
            this.priceList = priceList;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }                
    }