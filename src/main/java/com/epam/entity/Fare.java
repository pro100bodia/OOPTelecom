package com.epam.entity;

import java.io.Serializable;

public abstract class Fare implements Entity {
    private static long serialVersionUID = 0;

    String name;
    int intCalls;
    int extCalls;
    int smsAmount;

    public Fare(String name, int intCalls, int extCalls, int smsAmount) {
        this.name = name;
        this.intCalls = intCalls;
        this.extCalls = extCalls;
        this.smsAmount = smsAmount;
    }

    public String getResourceFile(){
        return "fares.txt";
    }

    public abstract Double calculateFee();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIntCalls(int intCalls) {
        this.intCalls = intCalls;
    }

    public void setExtCalls(int extCalls) {
        this.extCalls = extCalls;
    }

    public void setSmsAmount(int smsAmount) {
        this.smsAmount = smsAmount;
    }

    public int getIndex(){return 0;}

    public int compareTo(Fare n){
        return this.calculateFee().compareTo(n.calculateFee());
    }
}
