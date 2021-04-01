package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/

public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();

        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File dir = new File(packageName);
        File[] arrFiles = dir.listFiles();
        MyLoader loader = new MyLoader();


        for (File file : arrFiles) {

            if (file.isFile() && file.getName().endsWith(".class")) {
                try {
                    Class<?> clazz = loader.load(file.getAbsolutePath());
                    hiddenClasses.add(clazz);
                } catch (IOException e) {

                }
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        HiddenClass result = null;

        for (Class c : hiddenClasses) {
            if (c.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                try {
                    Constructor constructor = c.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    result= (HiddenClass) constructor.newInstance();
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
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

