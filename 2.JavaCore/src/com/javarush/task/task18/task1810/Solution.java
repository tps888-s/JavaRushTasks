package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception, DownloadException {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename1 = reader.readLine();

            FileInputStream inputStream = new FileInputStream(filename1);
            if (inputStream.available()<1000) {
                inputStream.close();
                throw new DownloadException();}
            }
        }



    public static class DownloadException extends Exception {

    }
}
