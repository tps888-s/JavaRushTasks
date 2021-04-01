package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception{
        //считываем имена файлов
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        //создаем потоки чтения из файлов
        FileReader r1 = new FileReader(file1);
        FileReader r2 = new FileReader(file2);

        String s1="";
        String s2="";

        //считываем данные из файлов в строки s1 и s2
        while (r1.ready()) {
            s1 = s1 + Character.toString((char)r1.read());
        }
        while (r2.ready()) {
            s2 = s2 + Character.toString((char)r2.read());
        }

        //закрываем потоки чтения
        r1.close();
        r2.close();

        //разбиваем строки на массивы
        String[] s_arr1 = s1.split("\\R");
        String[] s_arr2 = s2.split("\\R");

        //переносим массивы в Arraylist

        ArrayList<String> l1 = new ArrayList<>(Arrays.asList(s_arr1));
        ArrayList<String> l2 = new ArrayList<>(Arrays.asList(s_arr2));

        int size = 0;
       /* int size1 = s_arr1.length;
        int size2 = s_arr2.length;


        if (size1>size2) l2.add("");
        if (size1<size2) l1.add("");
        if (size1==size2)l1.add("");*/

        //проверка на same, add, remove

        while (true) {

            if (l1.size()-1>=size && l2.size()-1>=size) {

                    if (l1.get(size).equals(l2.get(size))) lines.add(new LineItem(Type.SAME, l2.get(size)));
                    else {
                        if (l1.get(size).equals(l2.get(size + 1))) {lines.add(new LineItem(Type.ADDED, l2.get(size))); l1.add(size,"");}
                        else {if (l2.get(size).equals(l1.get(size + 1))) {lines.add(new LineItem(Type.REMOVED, l1.get(size))); l2.add(size,"");}}
                    }

                    size++;
            }

            else{
                //lines.add(new LineItem(Type.SAME, l2.get(size)));

                if (l1.size()-1==size) lines.add(new LineItem(Type.REMOVED, l1.get(size)));
                if (l2.size()-1==size) lines.add(new LineItem(Type.ADDED, l2.get(size)));
                break;
            }
            }

        for (LineItem l : lines) {
            System.out.println(l.type + " " + l.line);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
