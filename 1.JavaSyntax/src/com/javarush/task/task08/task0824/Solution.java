package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args)  {
        //напишите тут ваш код
        ArrayList<Human> child0 = new ArrayList<Human>();

        Human ch1 = new Human("Дите1", true, 10, child0 );
        Human ch2 = new Human("Дите2", false, 9, child0 );
        Human ch3 = new Human("Дите3", false, 7, child0 );

        ArrayList<Human> child3 = new ArrayList<Human>();
        child3.add(ch1);
        child3.add(ch2);
        child3.add(ch3);

        Human p = new Human("Папа", true, 39, child3 );
        Human m = new Human("Мама", false, 38, child3 );

        ArrayList<Human> child1 = new ArrayList<Human>();
        child1.add(p);
        ArrayList<Human> child2 = new ArrayList<Human>();
        child2.add(m);



        Human d1 = new Human("Дед1", true, 99, child1 );
        Human d2 = new Human("Дед2", true, 99, child2 );
        Human b1 = new Human("Баба1", false, 98, child1 );
        Human b2 = new Human("Баба2", false, 98, child2 );



        System.out.println(d1);
        System.out.println(b1);
        System.out.println(d2);
        System.out.println(b2);
        System.out.println(p);
        System.out.println(m);
        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(ch3);

    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human (String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human (String name, boolean sex, int age, ArrayList<Human> children ) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children=children;
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;


            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
