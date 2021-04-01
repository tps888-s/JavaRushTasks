package com.javarush.task.task17.task1721;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname1 = reader.readLine();
        String fname2 = reader.readLine();

        BufferedReader inStream1 = new BufferedReader(new FileReader(fname1));
        BufferedReader inStream2 = new BufferedReader(new FileReader(fname2));

        while (inStream1.ready() ) {
            allLines.add(inStream1.readLine()) ;
        }

        while (inStream2.ready() ) {
            forRemoveLines.add(inStream2.readLine()) ;
        }

        reader.close();
        inStream1.close(); //закрываем потоки
        inStream2.close();

        new Solution().joinData();


    }

    public void joinData() throws CorruptedDataException {
       List<String> check = new ArrayList<>();

       for (int i = 0; i < forRemoveLines.size();i++) {
           String x = forRemoveLines.get(i);
           for (int y = 0; y < allLines.size(); y++) {
               String x1 = allLines.get(y);
               if (x1.equals(x)) check.add(x);

           }
       }
           if (check.size()==forRemoveLines.size()) {
               for (int i = 0; i < forRemoveLines.size(); i++) {
                   String x = forRemoveLines.get(i);
                   for (int y = 0; y < allLines.size(); y++) {
                       String x1 = allLines.get(y);
                       if (x1.equals(x)) allLines.remove(y);
                   }
               }
           }

               else {
                   allLines.clear();
                   throw new CorruptedDataException();}
    }
}
