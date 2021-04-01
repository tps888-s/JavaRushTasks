package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human d1 = new Human("d1", true,100);
        Human d2 = new Human("d2", true,100);

        Human b1 = new Human("b1", false,98);
        Human b2 = new Human("b2", false,98);

        Human p = new Human("p", true,35, d1, b1);
        Human m = new Human("m", false,33, d2, b2);

        Human s1 = new Human("s1", true,10, p, m);
        Human do1 = new Human("d1", false,5, p, m);
        Human do2 = new Human("d2", false,2, p, m);

        System.out.println(d1.toString());
        System.out.println(d2.toString());
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(p.toString());
        System.out.println(m.toString());
        System.out.println(s1.toString());
        System.out.println(do1.toString());
        System.out.println(do2.toString());
    }

    public static class Human {
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human (String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human (String name, boolean sex, int age, Human father, Human mother ){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father=father;
            this.mother=mother;
        }



        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}