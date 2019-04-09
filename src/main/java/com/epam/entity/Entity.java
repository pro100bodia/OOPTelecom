package com.epam.entity;

import java.io.Serializable;

public interface Entity extends Serializable, Comparable<Entity> {
    int getIndex();
    String getName();
    String getResourceFile();
}
