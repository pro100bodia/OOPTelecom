package com.epam.entity;

public class InternetBasedFare extends Fare implements Internetable {
    int megabytes;

    public InternetBasedFare(int id, String name, int intCalls, int extCalls, int smsAmount, int megabytes) {
        super(id, name, intCalls, extCalls, smsAmount);
        setInternetMegabytes(megabytes);
    }

    public void setInternetMegabytes(int megabytes) {
        this.megabytes = megabytes;
    }

    public int getInternetMegabytes() {
        return megabytes;
    }

    double calculateFee() {
        return intCalls * .05f + extCalls * .1f + smsAmount * .15f + megabytes * .4f;
    }
}
