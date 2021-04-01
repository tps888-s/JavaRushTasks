package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String>  implements Serializable, Cloneable{
    Entry<String> root;
    ArrayList<Entry<CustomTree>> list = new ArrayList<>();
    ArrayList<Entry<CustomTree>> listToDel = new ArrayList<>();


    public CustomTree() {
        this.root = new Entry<>("0");
        list.add(new Entry<CustomTree>("0"));
        }

    @Override
    public String get(int index) {

        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {


        return list.size() - 1;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }


    public boolean add(String s) {
        //создаем новый элемент
        Entry<CustomTree> newEntry = new Entry<CustomTree>(s);

        //определяем его родителя
        Entry<CustomTree> parent = null;
        for (int i = 0; i < list.size(); i++){

            if (list.get(i).isAvailableToAddChildren()) {
                parent = list.get(i);
                break;
            }
        }

        /*
        Entry<CustomTree> parent =  list.stream()
                .filter(element -> element.isAvailableToAddChildren())
                .sorted(Comparator.comparing(Entry::getElementNameAsDigit))
                .collect(Collectors.toList()).get(0);

         */
        //если не нашлось доступного родителя
        if (parent == null){
            for (int i = 0; i < list.size(); i++){
                Entry entryParent = list.get(i);
                int countChildren = 0;
                for (int x = 1; x < list.size(); x++  ){
                    if (list.get(x).parent.equals(entryParent)) {
                       countChildren++;
                    }
                }
                if (countChildren == 0) {
                 entryParent.availableToAddLeftChildren = true;
                 entryParent.availableToAddRightChildren = true;
                 parent = entryParent;
                 break;
                }
            }
        }
        newEntry.parent = parent;

        //актуализируем возможность добавления детей
        if (parent.availableToAddLeftChildren) parent.availableToAddLeftChildren = false;
        else parent.availableToAddRightChildren = false;

        //добавляем новую запись в общий список
        list.add(newEntry);

        //System.out.println(newEntry.elementName + " - " + parent.elementName);
        return true;
    }

    public String getParent(String s){
        String parentName = "null.";

        for (Entry e : list){
            if (e.elementName.equals(s)) parentName = e.parent.elementName;
        }

        return parentName;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) throw new UnsupportedOperationException();

        for (int i = 1; i < list.size(); i++){
            Entry entry = list.get(i);
            if (entry.elementName.equals(o)) {
                removeChildren(entry.elementName);
                listToDel.add(entry);
            }
        }

        for (Entry e : listToDel){
            if (list.contains(e)) list.remove(e);
        }

        return true;
    }

    public void removeChildren(String parentName) {

        for (int i = 1; i < list.size(); i++){
            Entry entry = list.get(i);
            if (entry.parent.elementName.equals(parentName)) {
                removeChildren(entry.elementName);
                listToDel.add(entry);
            }
        }
    }


    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    static class Entry<CustomTree> implements Serializable{

        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<CustomTree> parent;
        Entry<CustomTree>leftChild;
        Entry<CustomTree>rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {

            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        public int getElementNameAsDigit() {
            return Integer.parseInt(elementName);
        }
    }
}
