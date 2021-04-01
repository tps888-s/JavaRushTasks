package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        BufferedReader filer = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));


        ArrayList<String> lines = new ArrayList<>();
        String line;

        while (true) {
            line = filer.readLine();
            if (line == null) break;
            else lines.add(line);
        }


        if (args.length != 0 && args[0].equals("-d")) {


            String id = args[1];
            int id_length = id.length();

            for (int i = id_length; i < 8; i++) {
                id = id + " ";
            }


            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).substring(0,8).equals(id)) {
                    lines.remove(i);
                }

            }
            String line_to_write="";

            for (String l : lines){
                line_to_write=line_to_write+l+"\n";
            }

            BufferedWriter filew = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
            filew.write(line_to_write);
            filew.close();
        }


            if (args.length != 0 && args[0].equals("-u")) {

                String id = args[1];
                int id_length = id.length();

                for (int i = id_length; i < 8; i++) {
                    id = id + " ";
                }

                String price = args[args.length - 2];
                int price_length = price.length();

                for (int i = price_length; i < 8; i++) {
                    price = price + " ";
                }

                String qnty = args[args.length - 1];
                int qnty_length = qnty.length();

                for (int i = qnty_length; i < 4; i++) {
                    qnty = qnty + " ";
                }

                String productName = "";

                for (int i = 2; i < args.length - 2; i++) {
                    productName = productName + args[i] + " ";
                }

                int productName_length = productName.length();

                for (int i = productName_length; i < 30; i++) {
                    productName = productName + " ";
                }

                for (int i = 0; i < lines.size(); i++) {
                    if (lines.get(i).substring(0, 8).equals(id)) {
                        lines.remove(i);
                        lines.add(i, id.substring(0, 8) + productName.substring(0, 30) + price.substring(0, 8) + qnty.substring(0, 4));
                    }
                }
                String line_to_write="";

                for (String l : lines){
                    line_to_write=line_to_write+l+"\n";
                }

                BufferedWriter filew = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
                filew.write(line_to_write);
                filew.close();
            }

            filer.close();


    }
}
