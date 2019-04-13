package com.epam.entity;

public class PremiumBasedFare extends Fare implements Internetable, TVable {
    int megabytes, tvChanels;

    public PremiumBasedFare(String name, int intCalls, int extCalls, int smsAmount, int megabytes, int tvChanels) {
        super(name, intCalls, extCalls, smsAmount);
        setInternetMegabytes(megabytes);
        setTVchanels(tvChanels);
    }

    public Double calculateFee() {
        return new Double(intCalls * .025f + extCalls * .05f + smsAmount * .07f + megabytes * .2f + tvChanels * .2f);
    }

    public int getInternetMegabytes() {
        return 0;
    }

    public void setInternetMegabytes(int megabytes) {

    }

    public void setTVchanels(int tVchannels) {

    }

    public int getTVchanels() {
        return 0;
    }
}
