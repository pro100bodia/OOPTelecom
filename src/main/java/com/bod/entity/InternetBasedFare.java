package com.bod.entity;

public class InternetBasedFare extends Fare implements Internetable {
    int megabytes;

    public InternetBasedFare(String name, int intCalls, int extCalls, int smsAmount, int megabytes) {
        super(name, intCalls, extCalls, smsAmount);
        setInternetMegabytes(megabytes);
    }

    public void setInternetMegabytes(int megabytes) {
        this.megabytes = megabytes;
    }

    public int getInternetMegabytes() {
        return megabytes;
    }

    public Double calculateFee() {
        return new Double(intCalls * .05f + extCalls * .1f + smsAmount * .15f + megabytes * .4f);
    }
}



