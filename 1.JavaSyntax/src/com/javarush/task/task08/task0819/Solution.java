package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        Iterator<Cat> itr = cats.iterator();
        int x =0;
       /* while(itr.hasNext())
        {
            x++;
           if (x==2)cats.remove(itr.next());
            }*/
        cats.remove(cats.iterator().next());
        printCats(cats);
        //напишите тут ваш код. step 3 - пункт 3


    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        Set<Cat> cats = new HashSet<Cat>();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        for (Cat s : cats) {
            System.out.println(s);
        }
    }

    // step 1 - пункт 1
    public static class Cat{

    }
}
