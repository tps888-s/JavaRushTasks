package com.javarush.task.task33.task3310.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileBucket {
    private Path path;

    public FileBucket() {

        try {
            path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);

        } catch (IOException e) {
            e.printStackTrace();
        }
        path.toFile().deleteOnExit();


    }

    public long getFileSize(){
        try {
           return Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void putEntry(Entry entry){
        try {
            OutputStream out = Files.newOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(out);
            objectOut.writeObject(entry);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Entry getEntry(){

        if (getFileSize() > 0) {
            try {
                InputStream in = Files.newInputStream(path);
                ObjectInputStream objectIn = new ObjectInputStream(in);
                return (Entry) objectIn.readObject();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
