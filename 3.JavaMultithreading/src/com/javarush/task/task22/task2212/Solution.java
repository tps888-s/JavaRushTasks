package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        if (telNumber.length()<10) return false;
        if (telNumber.matches("\\W?\\d\\d\\(?\\d{3}\\)?\\d{3}\\W?\\d{2}\\W?\\d{2}")) return true;
        if (telNumber.matches("\\W?\\d{3}\\W?\\d{3}\\W?\\d{2}\\W?\\d{2}")) return true;
        else return false;
    }

    public static void main(String[] args) {


    }
}
