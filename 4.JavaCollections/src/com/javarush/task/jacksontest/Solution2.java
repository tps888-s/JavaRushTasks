package com.javarush.task.jacksontest;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;

public class Solution2 {
    public static void main(String[] args) throws IOException {

        String jsonString = "{ \"name\":\"Murka\", \"age\":5, \"weight\":4}";
        StringReader reader = new StringReader(jsonString);

        ObjectMapper mapper = new ObjectMapper();

        Cat cat = mapper.readValue(reader, Cat.class);

        System.out.println("name: " + cat.name + " age:" + cat.age + " weight:" + cat.weight);
    }
}
