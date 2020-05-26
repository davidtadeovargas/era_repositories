package com.era.repositories;

import com.era.models.Payment;

public class PaymentsRepository extends Repository {

   public PaymentsRepository() {
        super(Payment.class);
    }
}