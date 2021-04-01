package com.javarush.task.task09.task0927;

import java.util.*;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String, Cat> map = new HashMap<String, Cat>();
           map.put("C1", new Cat("C1"));
        map.put("C2", new Cat("C2"));
        map.put("C3", new Cat("C3"));
        map.put("C4", new Cat("C4"));
        map.put("C5", new Cat("C5"));
        map.put("C6", new Cat("C6"));
        map.put("C7", new Cat("C7"));
        map.put("C8", new Cat("C8"));
        map.put("C9", new Cat("C9"));
        map.put("C10", new Cat("C10"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> set = new HashSet<Cat>();
        for (Map.Entry<String, Cat> pair : map.entrySet()){
            Cat c = pair.getValue();
            set.add(c);
        }

        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
