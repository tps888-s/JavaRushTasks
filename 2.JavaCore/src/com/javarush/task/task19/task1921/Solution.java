package com.javarush.task.task19.task1921;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception{

        FileReader r = new FileReader(args[0]);

        String s1 = "";

            while (r.ready()) {
                char ch1 = (char)r.read();
                s1= s1 + Character.toString(ch1);
            }
            r.close();

            String[] s_arr = s1.split("\\n");
            int size = s_arr.length;
            for (int i = 0; i < size; i++) {
                String[] s2 = s_arr[i].split(" ");
                int size2 = s2.length;
                String name = "";
                String date = "";

                for (int z = 0; z < size2 - 3; z++) {
                    name = name + s2[z] + " ";
                }

                for (int z = size2 - 3; z < size2; z++) {
                    date = date + s2[z] + "/";
                }
                name = name.substring(0, name.length() - 1);
                date = date.substring(0, date.length() - 1);
                PEOPLE.add(new Person(name, new SimpleDateFormat("dd/MM/yyyy").parse(date)));
            }

         /*   for (Person p : PEOPLE){
                System.out.println(p.getName());
                System.out.println(p.getBirthDate());
            }

          */
    }
}
