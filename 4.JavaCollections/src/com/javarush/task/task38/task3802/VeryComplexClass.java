package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.text.SimpleDateFormat;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        format.parse("zxc");

    }

    public static void main(String[] args) {

    }
}
