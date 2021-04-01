package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // List of addresses
        List<String> addresses = new ArrayList<>();
        ArrayList<String> citylist = new ArrayList<String>();
        int y = 1;

        while (true) {
            String family = reader.readLine();
            if (y%2==0) addresses.add(family);
            else citylist.add(family);
            y++;
            if (family.isEmpty()) break;
        }

        // Read the house number
        String city = reader.readLine();
        int x=0;
            for (String c : citylist) {
             if (c.equals(city)) System.out.print(addresses.get(x));
             x++;
                }

    }
}
