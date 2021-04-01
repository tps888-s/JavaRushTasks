package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        int fileSize = content.length;
        String fileName = file.getFileName().toString();

        StringBuilder sb = new StringBuilder("");

        for (int i =0; i < fileSize; i++){
            sb.append((char)content[i]);
        }

        String fileContent = sb.toString();


        int checkList = 0;
        int checkResult = 0;

        if (partOfName != null) checkList = checkList | 1;
        if (partOfContent != null ) checkList = checkList | 2;
        if (minSize > 0) checkList = checkList | 4;
        if (maxSize > 0) checkList = checkList | 8;

        if (partOfName != null && fileName.contains(partOfName)) checkResult = checkResult | 1;
        if (partOfContent != null && fileContent.contains(partOfContent) ) checkResult = checkResult | 2;
        if (minSize > 0 && fileSize >= minSize) checkResult = checkResult | 4;
        if (maxSize > 0 && fileSize <= maxSize) checkResult = checkResult | 8;

        if (checkList == checkResult) foundFiles.add(file);

        return super.visitFile(file, attrs);
    }
}
