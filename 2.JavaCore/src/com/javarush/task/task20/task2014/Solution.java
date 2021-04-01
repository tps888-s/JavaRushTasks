package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args)  throws Exception{
        System.out.println(new Solution(4));

        //try {
            Solution savedobject = new Solution(25);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:\\pz2.txt"));
            out.writeObject(savedobject);
            out.close();


            ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:\\pz2.txt"));
            Solution loadedobject = (Solution)in.readObject();
            if (savedobject.string.equals(loadedobject.string)) System.out.println(true);
            in.close();
        //}

      //  catch (Exception e) {
         //   System.out.println(e.getStackTrace());
        //}

    }

   transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
