package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner fileScanner;

        PersonScannerAdapter(Scanner fileScanner ) {
            this.fileScanner = fileScanner;

        }

        @Override
        public Person read() throws IOException {
            String ps = this.fileScanner.nextLine();
            String[] arr = ps.split(" ");
            Person person=null;
            try {
                person = new Person(arr[1], arr[2], arr[0], new SimpleDateFormat("dd/MM/yyyy").parse(arr[3] +"/"+ arr[4] +"/"+ arr[5]));
            }
            catch (Exception e) {

            }

            return person;
        }

        @Override
        public void close() throws IOException {
                this.fileScanner.close();
        }
    }
}
