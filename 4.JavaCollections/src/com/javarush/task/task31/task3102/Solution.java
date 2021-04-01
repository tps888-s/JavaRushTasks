package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> resulList = new ArrayList<>();
        Queue<File> queue = new PriorityQueue<>();
        queue.add(new File(root));

        while (queue.size()>0){
            File directory = queue.poll();
            if (directory != null && directory.listFiles() != null) {
                for (File f : directory.listFiles()) {
                    if (f.isDirectory()) {
                        queue.add(f);
                    } else {
                        resulList.add(f.getAbsolutePath());
                    }
                }
            }
        }

        return resulList;

    }

    public static void main(String[] args) {
      /*
        List<String> list = null;
        try {
        list = getFileTree("c:/test");
        } catch (IOException e) {
            e.printStackTrace();
        }


        for(String s : list) {
            System.out.println(s);
        }
       */
    }
}
