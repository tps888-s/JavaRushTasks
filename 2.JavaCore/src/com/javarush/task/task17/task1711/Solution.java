package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        //start here - начни тут
        int size = args.length;

        switch (args[0]) {
            //create
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < size; i = i + 3) {
                        if (args[i + 1].equals("м"))
                            allPeople.add(Person.createMale(args[i], new SimpleDateFormat("dd/MM/yyyy").parse(args[i + 2])));
                        else
                            allPeople.add(Person.createFemale(args[i], new SimpleDateFormat("dd/MM/yyyy").parse(args[i + 2])));

                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;

            //update
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < size; i = i + 4) {
                        Person p1 = allPeople.get(Integer.parseInt(args[i]));
                        p1.setName(args[i + 1]);
                        if (args[i + 2].toString().equals("м")) p1.setSex(Sex.MALE);
                        else p1.setSex(Sex.FEMALE);
                        p1.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(args[i + 3]));
                    }
                }
                break;

            //delete
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < size; i++) {
                        Person p1 = allPeople.get(Integer.parseInt(args[i]));
                        p1.setName(null);
                        p1.setSex(null);
                        p1.setBirthDate(null);
                    }
                }
                break;

            //information
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < size; i++) {

                        Person p1 = allPeople.get(Integer.parseInt(args[i]));
                        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


                        System.out.print(p1.getName());
                        System.out.print(" ");
                        if (p1.getSex().toString().equals("MALE")) System.out.print("м");
                        else System.out.print("ж");
                        System.out.print(" ");
                        System.out.print(dateFormat.format(p1.getBirthDate()));
                        System.out.println("");

                    }
                }
                break;

        }
    }
}
