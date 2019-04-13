package com.epam.entity;

public class SimpleBasedFare extends Fare {
    public SimpleBasedFare(String name, int intCalls, int extCalls, int smsAmount) {
        super(name, intCalls, extCalls, smsAmount);
    }

    public Double calculateFee() {
        return new Double(intCalls * .1f + extCalls * .2f + smsAmount * .3f);
    }
}
