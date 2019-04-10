package com.epam.entity;

public class TVBasedFare extends Fare implements TVable {
    int tvChanels;

    public TVBasedFare(String name, int intCalls, int extCalls, int smsAmount, int tvChanels) {
        super(name, intCalls, extCalls, smsAmount);
        setTVchanels(tvChanels);
    }

    public Double calculateFee() {
        return new Double(intCalls * .05f + extCalls * .1f + smsAmount * .15f + tvChanels * .4f);
    }

    public void setTVchanels(int tvChanels) {
        this.tvChanels = tvChanels;
    }

    public int getTVchanels() {
        return this.tvChanels;
    }
}
