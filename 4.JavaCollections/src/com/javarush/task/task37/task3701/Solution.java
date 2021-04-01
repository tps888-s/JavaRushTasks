package com.javarush.task.task37.task3701;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* 
Круговой итератор
*/

public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {

        return new RoundIterator();
    }

    public class RoundIterator implements Iterator<T> {

        int cursor;       // index of next element to return


        Iterator itr;

        public RoundIterator() {
            itr = Solution.super.iterator();
        }


        public boolean hasNext() {
            return Solution.this.size()>0;
        }


        public T next() {

            if (cursor >= Solution.this.size()) {
                itr = Solution.super.iterator();
                cursor = 0;
            }
            cursor++;

            return (T)itr.next();
        }

        public void remove() {
            itr.remove();
        }
    }


    }
