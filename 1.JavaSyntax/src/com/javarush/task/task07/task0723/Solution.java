package com.javarush.task.task07.task0723;

/* 
Обратный отсчёт
*/

public class Solution {
    public static void main(String[] args)  throws InterruptedException {
        for (int i = 30; i >= 0; i--) {

            System.out.println(i);
            try{ Thread.sleep(100);
            } catch (Exception e){
            }
            //напишите тут ваш код
        }

        System.out.println("Бум!");
    }
}
