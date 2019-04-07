package com.epam.entity;

public class TVBasedFare extends Fare implements TVable {
    int tvChanels;

    public TVBasedFare(int id, String name, int intCalls, int extCalls, int smsAmount, int tvChanels) {
        super(id, name, intCalls, extCalls, smsAmount);
        setTVchanels(tvChanels);
    }

    double calculateFee() {
        return intCalls * .05f + extCalls * .1f + smsAmount * .15f + tvChanels * .4f;
    }

    public void setTVchanels(int tvChanels) {
        this.tvChanels = tvChanels;
    }

    public int getTVchanels() {
        return this.tvChanels;
    }
}
