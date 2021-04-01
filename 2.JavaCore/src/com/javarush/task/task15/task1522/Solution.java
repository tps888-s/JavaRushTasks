package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) throws Exception {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet()  {
        // implement step #5 here - реализуйте задание №5 тут
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            String s = r.readLine();
            if (s.equals("sun")) thePlanet = Sun.getInstance();
            else if (s.equals("moon")) thePlanet = Moon.getInstance();
            else if (s.equals("earth")) thePlanet = Earth.getInstance();
            else thePlanet = null;
            //System.out.print(thePlanet);
        }
        catch (Exception e) {
        }

    }
}
