package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception{
        //start here - начни тут
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


            
            //create
            if (args[0].equals("-c")) {
                if (args[2].equals("м"))
                allPeople.add(Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3])));
                else
                allPeople.add(Person.createFemale(args[1],new SimpleDateFormat("dd/MM/yyyy").parse(args[3])));

                System.out.println(allPeople.size()-1);
            }

            //update
            if (args[0].equals("-u")) {
                Person p1 = allPeople.get(Integer.parseInt(args[1]));
                p1.setName(args[2]);
                if (args[3].toString().equals("м")) p1.setSex(Sex.MALE); else p1.setSex(Sex.FEMALE);
                p1.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(args[4]));
            }

            //delete
            if (args[0].equals("-d")) {
                Person p1 = allPeople.get(Integer.parseInt(args[1]));
                p1.setName(null);
                p1.setSex(null);
                p1.setBirthDate(null);
            }

            //information
            if (args[0].equals("-i")) {
                Person p1 = allPeople.get(Integer.parseInt(args[1]));
                DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


                System.out.print(p1.getName());
                System.out.print(" ");
                if (p1.getSex().toString().equals("MALE")) System.out.print("м"); else System.out.print("ж");
                System.out.print(" ");
                System.out.print( dateFormat.format(p1.getBirthDate()));

            }

            //if (ch1=='1')break;

            }
}
