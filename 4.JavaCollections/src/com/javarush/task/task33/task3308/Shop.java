package com.javarush.task.task33.task3308;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    @XmlElement(name = "goods")
    public Goods goods;
    @XmlElement(name = "count")
    public int count;
    @XmlElement(name = "profit")
    public double profit;
    @XmlElement(name = "secretData")
    public String[] secretData = new String[5];

    @XmlType(name = "goods")
    public static class Goods {
        public List<String> names = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Shop{" +
                "goods=" + goods +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + secretData +
                '}';
    }
}
