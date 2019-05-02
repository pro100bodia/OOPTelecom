package com.bod.entity;

public class Client implements Entity {
    String name;
    String fareId;

    public Client(String name, String fareId) {
        this.name = name;
        setFareId(fareId);
    }


    public String getName() {
        return name;
    }

    public String getFareId() {
        return fareId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFareId(String fareId) {
        this.fareId = fareId;
    }

}
