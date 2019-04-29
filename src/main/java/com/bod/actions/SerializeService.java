package com.bod.actions;

import com.bod.entity.Entity;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class SerializeService<T extends Entity> {
    private String fileName;

    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;

    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;

    private LinkedList<T> list;

    public SerializeService(String entity) {
        fileName = System.getProperty("user.home") + "\\" + entity;
    }

    public void serialize(List entity){

        try {
            this.fileOutputStream = new FileOutputStream(fileName);
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
        list = new LinkedList<>();

        try {
            this.fileInputStream = new FileInputStream(fileName);
            this.objectInputStream = new ObjectInputStream(fileInputStream);

            list = (LinkedList<T>)objectInputStream.readObject();


        }catch(EOFException e){
            try {
                objectInputStream.close();
                return new LinkedList<T>();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }catch(IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally{
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch(NullPointerException e){
                return new LinkedList<T>();
            }
        }

        return list;
    }
}



