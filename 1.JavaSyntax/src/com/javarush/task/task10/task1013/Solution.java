package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private boolean sex;
        private String edu;
        private int height;
        private String momname;

        public Human(String name){ //1
            this.name=name;
        }
        public Human(String name, int age){ //2
            this.name=name;
            this.age=age;
        }
        public Human(String name, int age, boolean sex){ //3
            this.name=name;
            this.age=age;
            this.sex=sex;
        }
        public Human(String name, boolean sex){ //4
            this.name=name;
            this.sex=sex;
        }
        public Human(String name, int age, boolean sex, String edu ){ //5
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.edu=edu;
        }
        public Human(String name, int age, boolean sex, String edu, int height ){ //6
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.edu=edu;
            this.height=height;
        }
        public Human(String name, int age, boolean sex, String edu, int height, String momname ){ //7
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.edu=edu;
            this.height=height;
            this.momname=momname;
        }
        public Human(String name, int age, boolean sex, int height, String momname ){ //8
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.height=height;
            this.momname=momname;
        }
        public Human(String name, int age, boolean sex, int height  ){ //9
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.height=height;
        }
        public Human(String name,  String edu, int height, String momname ){ //10
            this.name=name;
            this.edu=edu;
            this.height=height;
            this.momname=momname;
        }
    }
}
