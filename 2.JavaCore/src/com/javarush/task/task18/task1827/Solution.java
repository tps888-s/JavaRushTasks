package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {



        if (args.length !=0 && args[0].equals("-c")) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename = reader.readLine();
            BufferedReader filer = new BufferedReader(new InputStreamReader (new FileInputStream(filename)));


            BufferedWriter filew = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename, true)));

            ArrayList<Integer> lines = new ArrayList<>();
            String line;

            while (true) {
                line = filer.readLine();
                if (line == null) break;
                else

                    lines.add(Integer.parseInt(line.substring(0,8).replaceAll(" ","")));

            }
            Collections.sort(lines);

            Integer newid = lines.get(lines.size()-1)+1;

            String id = newid.toString();

            int id_length = id.length();

            for (int i = id_length; i<8; i++){
                id = id+" ";
            }

            String price=args[args.length-2];
            int price_length = price.length();

            for (int i = price_length; i<8; i++){
                price = price+" ";
            }


            String qnty =args[args.length-1];
            int qnty_length = qnty.length();

            for (int i = qnty_length; i<4; i++){
                qnty = qnty+" ";
            }


            String productName = "";

            for (int i = 1; i< args.length-2; i++ ){
                productName=productName+args[i]+" ";
            }

            int productName_length = productName.length();

            for (int i = productName_length; i<30; i++){
                productName = productName+" ";
            }

            filew.newLine();
            filew.write(id.substring(0,8)+productName.substring(0,30)+price.substring(0,8)+qnty.substring(0,4));


            //System.out.println(id+productName+price_qnty);
            filer.close();
            filew.close();
        }

    }
}
