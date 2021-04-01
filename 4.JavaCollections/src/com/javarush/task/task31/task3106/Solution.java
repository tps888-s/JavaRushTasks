package com.javarush.task.task31.task3106;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<String> set = new TreeSet<>();
        List<FileInputStream> list = new ArrayList<>();

        String fileName = args[0];


        for (int i = 1; i < args.length; i++){
        set.add(args[i]);
        }

        for (String s : set) {
            FileInputStream fileInputStream = new FileInputStream(s);
            list.add(fileInputStream);
        }

        try (
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(list)))
        ){
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {

                byte[] buffer = new byte[1024];
                int len;
                while ((len = zipInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, len);
                }
                zipEntry = zipInputStream.getNextEntry();
            }
        }
    }
}
