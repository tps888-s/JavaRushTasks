package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        HashMap<String, String> params = new HashMap<>();
        params.put("country","USA");
        params.put("city","LA");
        params.put("name","Petrov");
        params.put("age",null);

        System.out.println(getQuery(params));

    }

    public static String getQuery(Map<String, String> params) {

        if (params == null) return "";
        StringBuilder sb = new StringBuilder();
        int z = 0;
        for(Map.Entry<String, String> m : params.entrySet()){
            String key = m.getKey();
            String value = m.getValue();
            if (key != null && value != null && z==0) {sb.append(key+" = "+"'"+value+"'" ); z++;}
            else if (key != null && value != null) sb.append(" and "+key+" = "+"'"+value+"'");

        }
        return sb.toString().trim();
    }
}
