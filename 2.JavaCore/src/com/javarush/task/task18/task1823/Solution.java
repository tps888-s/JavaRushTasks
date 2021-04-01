package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String fname = reader.readLine();
            if (fname.equals("exit")) break;
           else new ReadThread(fname).start();
        }

        System.out.println(resultMap);

    }

    public static class ReadThread extends Thread {
         String fileName;

        public ReadThread(String fileName) throws Exception{
            //implement constructor body
            this.fileName=fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            try {
                BufferedInputStream file = new BufferedInputStream(new FileInputStream(fileName));
                byte[] b1 = new byte[file.available()];
                file.read(b1, 0, file.available());
                file.close();

                HashMap<Byte, Integer> map = new HashMap<>();

                for (int i = 0; i < b1.length; i++){
                    int count = 0;
                    for (byte b : b1){
                        if (b==b1[i]) count++;
                    }
                    map.put(b1[i], count);
                }

                ArrayList<Integer> sort = new ArrayList<>(map.values());
                Collections.sort(sort);

                for (Map.Entry<Byte,Integer> pair : map.entrySet()) {
                    if (sort.get(sort.size()-1)==pair.getValue()) {
                        resultMap.put(fileName,(int)pair.getKey());// нашли наше значение и возвращаем  ключ
                    }

            }
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
