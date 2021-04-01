package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        /*
        boolean check = false;
        if (f.isFile()) {
            String file_name = f.getName();
            file_name.toLowerCase();
            if (file_name.endsWith(".htm")) check = true;
            if (file_name.endsWith(".html")) check = true;
        }

        if (f.isDirectory()){
            for (File file : f.listFiles()){
                if (file.getName().toLowerCase().endsWith(".htm")) check = true;
                if (file.getName().toLowerCase().endsWith(".html")) check = true;
            }
        }*/

        return f.isDirectory() || f.getName().toLowerCase().endsWith(".htm") || f.getName().toLowerCase().endsWith(".html");
    }

    @Override
    public String getDescription() {


        return "HTML и HTM файлы";
    }
}
