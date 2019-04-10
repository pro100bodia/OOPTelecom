package com.epam.actions;

import com.epam.entity.Entity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Actions<T extends Entity>{
    private String fileName;

    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;

    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;

    private ArrayList<T> list;

    public Actions(String entity) {
        fileName = System.getProperty("user.home") + "\\" + entity;
    }

    public void serialize(Entity entity){

        try {
            this.fileOutputStream = new FileOutputStream(fileName, true);
            this.objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(entity);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<T> deserialize() {
        list = new ArrayList<T>();
        try {
            this.fileInputStream = new FileInputStream(fileName);
            this.objectInputStream = new ObjectInputStream(fileInputStream);

            T obj;
            while( (obj = (T)objectInputStream.readObject()) != null || objectInputStream.available() < 0 )
            {
                list.add(obj);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            try {
                fileInputStream.close();
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return list;
    }


}