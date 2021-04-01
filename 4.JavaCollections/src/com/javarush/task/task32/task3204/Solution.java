package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {

    ByteArrayOutputStream password = new ByteArrayOutputStream();

    //2 заглавные буквы
    password.write(65 + (int)(Math.random() * ((90 - 65) + 1)));
    password.write(65 + (int)(Math.random() * ((90 - 65) + 1)));
    //4 строчные буквы
    for (int i = 0; i < 4; i++) {
    password.write(97 + (int)(Math.random() * ((122 - 97) + 1)));
        }
    //2 цифры
    password.write(48 + (int)(Math.random() * ((57 - 48) + 1)));
    password.write(48 + (int)(Math.random() * ((57 - 48) + 1)));

        return password;
    }
}