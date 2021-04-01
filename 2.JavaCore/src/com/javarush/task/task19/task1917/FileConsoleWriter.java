package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(File file) throws IOException{
        FileWriter fileWriter = new FileWriter(file);
        this.fileWriter=fileWriter;
    }

    public FileConsoleWriter(File file, boolean append) throws IOException{
        FileWriter fileWriter = new FileWriter(file, append);
        this.fileWriter=fileWriter;
    }

    public FileConsoleWriter(FileDescriptor fd) throws IOException{
        FileWriter fileWriter = new FileWriter(fd);
        this.fileWriter=fileWriter;
    }

    public FileConsoleWriter(String filename) throws IOException{
        FileWriter fileWriter = new FileWriter(filename);
        this.fileWriter=fileWriter;
    }

    public FileConsoleWriter(String filename, boolean append) throws IOException{
        FileWriter fileWriter = new FileWriter(filename, append);
        this.fileWriter=fileWriter;
    }


    public void write(char[] cbuf) throws IOException {
        System.out.println(String.valueOf(cbuf));
        fileWriter.write(cbuf);
    }


    public void write(String str) throws IOException {
        System.out.println(str);
        fileWriter.write(str);
    }


    public void write(int c) throws IOException {
        System.out.println(c);
        fileWriter.write(c);
    }


    public void write(char[] cbuf, int off, int len) throws IOException {
        System.out.println(String.valueOf(cbuf).substring(off, off+len));
        fileWriter.write(cbuf, off, len);
    }


    public void write(String str, int off, int len) throws IOException {
        System.out.println(str.substring(off,off+len));
        fileWriter.write(str, off, len);
    }



    public void close() throws IOException {

        fileWriter.close();
    }

    public static void main(String[] args) {

    }

}
