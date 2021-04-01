package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {
        private static AtomicInteger countDirectories = new AtomicInteger(0);
        private static AtomicInteger countFiles = new AtomicInteger(0);
        private static AtomicLong totalSize = new AtomicLong(0);


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String directoryName = reader.readLine();
        Path directory = Paths.get(directoryName);
        Solution solution = new Solution();

        if (Files.isDirectory(directory)){
            Files.walkFileTree(directory, solution);

            System.out.println("Всего папок - " + countDirectories.decrementAndGet());
            System.out.println("Всего файлов - " + countFiles);
            System.out.println("Общий размер - " + totalSize);

        }
        else{
            System.out.println(directoryName + " - не папка");
        }
        reader.close();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        countFiles.incrementAndGet();
        totalSize.addAndGet(Files.size(file));
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            countDirectories.incrementAndGet();
        return super.postVisitDirectory(dir, exc);
    }
}
