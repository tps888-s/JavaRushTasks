package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("zz.txt", null);
            OutputStream outputStream = new FileOutputStream("c:\\p2.txt");
            InputStream inputStream = new FileInputStream("c:\\p2.txt");

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            //outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            if (somePerson.equals(ivanov)) System.out.println("имена совпадают");
            for (int i = 0; i < ivanov.assets.size(); i++) {
                if (ivanov.assets.get(i).equals(somePerson.assets.get(i))) System.out.println("asset"+i+" совпадают");
            }

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter p = new PrintWriter(outputStream);
            p.println(this.name);
            for (Asset a : this   .assets){
                p.println(a.getName());
                p.println(a.getPrice());
            }
          p.flush();


        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            String human_name = r.readLine();
            ArrayList<Asset> load_asset = new ArrayList<>();
            while (true){

                String asset_name = r.readLine();
                if (asset_name==null) break;
                Double asset_price = Double.parseDouble(r.readLine());
                load_asset.add(new Asset(asset_name,asset_price));
            }
            this.name=human_name;
            this.assets=load_asset;
        }
    }
}
