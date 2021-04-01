package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/

public class Solution {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<Animal> resultSet = new HashSet<>();
        MyLoader loader = new MyLoader();


       // System.out.println(pathToAnimals);
        //System.out.println(URLDecoder.decode(pathToAnimals, "UTF-8"));

        File dir = new File(pathToAnimals);
        File[] arrFiles = dir.listFiles();

        for (File file : arrFiles) {
            if (file.isFile() && file.getName().endsWith(".class")) {
                try{
                Class<?> clazz = loader.load(file.getAbsolutePath());
                Constructor c =clazz.getConstructor();

                if (c.getModifiers() == Modifier.PUBLIC && Animal.class.isAssignableFrom(clazz)) {
                    c.setAccessible(true);
                    resultSet.add((Animal) c.newInstance());
                }
                    }
                    catch(NoSuchMethodException e){

                    }
                }
            }

        return resultSet;
    }

    static class MyLoader extends ClassLoader {

        public MyLoader() {

        }


        public Class<?> load(String path) throws IOException {

            byte[] b = Files.readAllBytes(Paths.get(path));

            return defineClass(null, b, 0, b.length);
        }

    }
}
