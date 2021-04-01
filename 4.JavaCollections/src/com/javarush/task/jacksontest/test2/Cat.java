package com.javarush.task.jacksontest.test2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.LinkedList;
import java.util.List;

class Cat {
    public String name;
    @JsonDeserialize(as = LinkedList.class)
    public List<Cat> cats;
}