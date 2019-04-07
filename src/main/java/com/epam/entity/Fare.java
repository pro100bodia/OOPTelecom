package com.epam.entity;

public abstract class Fare implements Entity {
    int id;
    String name;
    int intCalls;
    int extCalls;
    int smsAmount;

    public Fare(int id, String name, int intCalls, int extCalls, int smsAmount) {
        this.id = id;
        this.name = name;
        this.intCalls = intCalls;
        this.extCalls = extCalls;
        this.smsAmount = smsAmount;
    }

    abstract double calculateFee();

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
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
}
