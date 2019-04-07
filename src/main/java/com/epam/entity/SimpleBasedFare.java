package com.epam.entity;

public class SimpleBasedFare extends Fare {
    public SimpleBasedFare(int id, String name, int intCalls, int extCalls, int smsAmount) {
        super(id, name, intCalls, extCalls, smsAmount);
    }

    double calculateFee() {
        return intCalls * .1f + extCalls * .2f + smsAmount * .3f;
    }
}
