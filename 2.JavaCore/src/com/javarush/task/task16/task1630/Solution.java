package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = r.readLine();
            secondFileName = r.readLine();
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String flnm;
        ArrayList<String> list = new ArrayList<>();


        public void run() {
            try {
                FileReader fr = new FileReader(flnm);
                BufferedReader reader = new BufferedReader(fr);
                String line = reader.readLine();
                while (line != null) {
                    list.add(line);
                    list.add(" ");
                    line = reader.readLine();
                }
                reader.close();
            } catch (Exception e) {
            }
        }

        @Override
        public String getFileContent() {
            String listString = "";
            for (String s : list)
            {
                listString += s /*+ "\t"*/;
            }
            return listString;
        }

        @Override
        public void setFileName(String fullFileName) {
            this.flnm = fullFileName;
        }
    }
}

