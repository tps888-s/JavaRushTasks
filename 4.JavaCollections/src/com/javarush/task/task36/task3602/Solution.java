package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {


         for(Class clazz : Collections.class.getDeclaredClasses()){

             if (Modifier.isPrivate(clazz.getModifiers()) &&
             Modifier.isStatic(clazz.getModifiers()) &&
                     List.class.isAssignableFrom(clazz)
             )
             {
                 try {
                     Constructor c = clazz.getDeclaredConstructor();
                     c.setAccessible(true);
                     Method method = clazz.getMethod("get",int.class);
                     method.setAccessible(true);
                     method.invoke(c.newInstance(),0);
                 } catch (NoSuchMethodException | IllegalAccessException | InstantiationException e) {
                     e.printStackTrace();
                 }
                 catch (InvocationTargetException e) {
                     if (e.getCause().toString().contains("IndexOutOfBoundsException")) {
                        // System.out.println(clazz.getCanonicalName());
                         return clazz;
                     }
                 }

             }
         }
        return null;
    }
}
