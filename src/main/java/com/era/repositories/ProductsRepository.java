package com.era.repositories;

import com.era.models.Product;

public class ProductsRepository extends Repository {

   public ProductsRepository() {
        super(Product.class);
    }
}