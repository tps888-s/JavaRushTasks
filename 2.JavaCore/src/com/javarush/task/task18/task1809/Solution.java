package com.javarush.task.task18.task1809;

/* 
Реверс файла
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

        int size = inputStream.available();
        if (inputStream.available() > 0) {
            //читаем весь файл одним куском


            byte[] buffer1 = new byte[size];
            byte[] buffer2 = new byte[size];
            inputStream.read(buffer1);

            for (int x = 0; x < size; x++){
                buffer2[x]=buffer1[size-1-x];
            }

            outputStream1.write(buffer2);

        }


        inputStream.close();
        outputStream1.close();


    }
}
