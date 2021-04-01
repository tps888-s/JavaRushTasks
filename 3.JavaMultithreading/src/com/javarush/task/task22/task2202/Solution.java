package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {

        if (string == null) throw new TooShortStringException();

        String s1 = "";
        int space1 = string.indexOf(" ");
        int space2 = string.indexOf(" ", space1+1);
        int space3 = string.indexOf(" ", space2+1);
        int space4 = string.indexOf(" ", space3+1);
        int space5 = string.indexOf(" ", space4+1);

        if (space1==-1 || space2==-1 || space3==-1 || space4==-1) throw new TooShortStringException();
        if (space5==-1) s1=string.substring(space1+1);
            else s1 = string.substring(space1+1,space5);
        return s1;
    }

    public static class TooShortStringException extends RuntimeException{

    }
}
