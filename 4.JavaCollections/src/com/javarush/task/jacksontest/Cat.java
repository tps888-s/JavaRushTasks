package com.javarush.task.jacksontest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
class Cat
{
    @JsonProperty("alias")
    public String name;
    public int age;
    @JsonIgnore
    public int weight;
    Cat(){}
}
