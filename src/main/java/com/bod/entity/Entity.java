package com.bod.entity;

import java.io.Serializable;

public interface Entity extends Serializable{
    int getIndex();
    String getName();
    String getResourceFile();
}
