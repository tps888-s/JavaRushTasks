package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(filename1);
        // Создаем поток-записи-байт-в-файл

        String filename2 = reader.readLine();
        FileOutputStream outputStream1 = new FileOutputStream(filename2);

        String filename3 = reader.readLine();
        FileOutputStream outputStream2 = new FileOutputStream(filename3);

        int size1,size2;

        if (inputStream.available() > 0) {
            //читаем весь файл одним куском
            if (inputStream.available() % 2 == 0) size1 = inputStream.available()/2;
            else size1=inputStream.available()/2+1;

            size2 = inputStream.available()-size1;

            byte[] buffer1 = new byte[size1];
            byte[] buffer2 = new byte[size2];

            inputStream.read(buffer1);
            inputStream.read(buffer2);
            outputStream1.write(buffer1);
            outputStream2.write(buffer2);
        }

        inputStream.close();
        outputStream1.close();
        outputStream2.close();
    }
}
