package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/*
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String file = r.readLine();
        r.close();

        FileInputStream in = new FileInputStream(file);
        load(in);
        in.close();

        }


    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод

        Properties pr = new Properties();

        for (Map.Entry<String, String> m : properties.entrySet()) {
            pr.setProperty(m.getKey(),m.getValue());
        }
        pr.save(outputStream, " ");

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties properties = new Properties();
        properties.load(inputStream);

        Set<String> prnames = properties.stringPropertyNames();

        for (String s : prnames){
            Solution.properties.put(s,properties.getProperty(s));
        }

    }

    public static void main(String[] args) throws Exception {
//    Solution s = new Solution();
//    s.fillInPropertiesMap();
//    System.out.println(Solution.properties);
//    OutputStream out = new FileOutputStream("c:\\p2.txt");
//    InputStream in = new FileInputStream("c:\\p2.txt");
//    s.save(out);
//    out.close();
//        Solution.properties.clear();
//    s.load(in);
//    in.close();
//
//    System.out.println(properties);

    }
}
