package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/
public class Solution {

    List<File> fileList = new ArrayList<>();

    void scanDirectory(File file){
        if (file.listFiles() != null) {
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    scanDirectory(f);
                } else {
                    if (f.length() <= 50) fileList.add(f);
                }
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        File file = new File(args[1]);
        File resultFile = new File(file.getParent() + "/allFilesContent.txt");

        if (FileUtils.isExist(file)) {
            FileUtils.renameFile(file, resultFile);
        }


       solution.scanDirectory(new File(args[0]));

        solution.fileList.sort(Comparator.comparing(File::getName));
        byte[] byte1 = "\n".getBytes();


        FileOutputStream fileOutputStream =null;
        FileInputStream fileInputStream;
        try {
            fileOutputStream = new FileOutputStream(resultFile, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (File f : solution.fileList){
            try {
                fileInputStream = new FileInputStream(f);
                byte[] buff = new byte[fileInputStream.available()];
                fileInputStream.read(buff);
                fileOutputStream.write(buff);
                fileOutputStream.write("\n".getBytes());
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
