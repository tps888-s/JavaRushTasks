package com.javarush.task.task37.task3707;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap((int) (Math.max(16,(int)collection.size()/0.75f + 1)));
        for (E e : collection){
            this.add(e);
        }
    }


    @Override
    public Iterator<E> iterator() {

        return map.keySet().iterator();
    }

    @Override
    public boolean add(Object o) {

            Object object = map.put((E) o, PRESENT);
            if (object == null)
            return true;
            else return false;

    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {

        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {

        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        Object object =  map.remove(o);

        if (object == null) return false;
        else return true;
    }

    @Override
    public Object clone() {
        AmigoSet clone =  new AmigoSet<>();
        try {
            clone.map = (HashMap) this.map.clone();
        }
        catch (Exception e){
            throw new InternalError();
        }
        return clone;
    }

    private void writeObject (ObjectOutputStream outputStream){
        try {
            outputStream.defaultWriteObject();
            outputStream.writeInt(size());
            outputStream.writeInt(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
            outputStream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
            for (E e : map.keySet()){
                outputStream.writeObject(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream inputStream){

        try {
            inputStream.defaultReadObject();
            int size = inputStream.readInt();
            int capacity = inputStream.readInt();
            float loadFactor = inputStream.readFloat();
            map = new HashMap<>(capacity, loadFactor);
            for (int i = 0; i < size; i++) {
                map.put((E)inputStream.readObject(), PRESENT);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("ddd");
        hashSet.add("rrrr");
        AmigoSet amigoSet = new AmigoSet(hashSet);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(amigoSet);
        objectOutputStream.close();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        AmigoSet amigoSet1 = (AmigoSet)  objectInputStream.readObject();
        //System.out.println(amigoSet.equals(amigoSet1));
        System.out.println(amigoSet);
        System.out.println("________");
        System.out.println(amigoSet1);
    }

}

