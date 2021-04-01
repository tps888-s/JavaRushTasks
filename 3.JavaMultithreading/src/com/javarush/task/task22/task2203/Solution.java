package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        if (string==null) throw new TooShortStringException();

        int tab1 = string.indexOf("\t");
        int tab2 = string.indexOf("\t",tab1+1);

        if (tab1==-1 || tab2==-1) throw new TooShortStringException();
        String s1 = string.substring(tab1+1,tab2);

        return s1;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
