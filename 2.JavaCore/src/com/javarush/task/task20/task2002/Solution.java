package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("c:\\p2.txt");
            InputStream inputStream = new FileInputStream("c:\\p2.txt");


            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            javaRush.users.add(new User());

            javaRush.users.get(0).setFirstName("Вася");
            javaRush.users.get(0).setLastName("Васин");
            javaRush.users.get(0).setBirthDate(new Date(946674000000L));
            javaRush.users.get(0).setMale(true);
            javaRush.users.get(0).setCountry(User.Country.RUSSIA);
            javaRush.users.add(new User());

            //System.out.println(javaRush.users.get(0).getBirthDate().getTime());

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            /*
            for (User u : loadedObject.users){

                System.out.println(u.getFirstName());
                System.out.println(u.getLastName());
                System.out.println(u.getBirthDate());
                System.out.println(u.isMale());
                System.out.println(u.getCountry());

            }*/
            for (int i = 0; i<loadedObject.users.size(); i++){
                if (javaRush.users.get(i).equals(loadedObject.users.get(i))) System.out.println("YES!");
            }


            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter w = new PrintWriter(outputStream);

            for (User u : users){
            w.println(u.getFirstName());
            w.println(u.getLastName());
            if (u.getBirthDate() != null) w.println(u.getBirthDate().getTime()); else w.println(u.getBirthDate());
            w.println(u.isMale());
            w.println(u.getCountry());
            w.flush();
            }
            w.close();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            int count = 0;
            while (true){
                String s1 = r.readLine();
                if (s1==null) break;
                //создаем пользователя
                this.users.add(new User());
                //First Name
                if (s1.equals("null")) this.users.get(count).setFirstName(null);
                else this.users.get(count).setFirstName(s1);
                //Last Name
                String s2 = r.readLine();
                if (s2.equals("null")) this.users.get(count).setLastName(null);
                else this.users.get(count).setLastName(s2);
                //Birth Date
                String s3 = r.readLine();
                if (s3.equals("null")) this.users.get(count).setBirthDate(null);
                else this.users.get(count).setBirthDate(new Date(Long.parseLong(s3)));
                //isMale
                String s4 = r.readLine();
                this.users.get(count).setMale(Boolean.parseBoolean(s4));
                //Country
                String s5 = r.readLine();
                if (s5.equals("null")) this.users.get(count).setCountry(null);
                else this.users.get(count).setCountry(User.Country.valueOf(s5));

                count++;
            }
            r.close();

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
