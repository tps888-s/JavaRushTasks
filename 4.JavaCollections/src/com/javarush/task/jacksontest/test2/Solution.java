package com.javarush.task.jacksontest.test2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String jsonString = "{\"name\":\"Murka\",\"cats\":[{\"name\":\"Timka\"},{\"name\":\"Killer\"}]}";
        ObjectMapper mapper = new ObjectMapper();
        Cat cat = mapper.readValue(jsonString, Cat.class);
        System.out.println(cat);
        System.out.println(cat.cats.getClass());
    }
}
