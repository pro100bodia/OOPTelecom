package com.epam.entity;

public class Client implements Entity {
    int id;
    String name;
    int fareId;

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
        this.fareId = fareId;
    }

    public int getId() {
        return 0;
    }

    public String getName() {
        return null;
    }

    public int getFareId() {
        return fareId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFareId(int fareId) {
        this.fareId = fareId;
    }
}
