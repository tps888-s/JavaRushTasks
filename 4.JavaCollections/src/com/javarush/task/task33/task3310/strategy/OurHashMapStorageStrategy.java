package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy implements StorageStrategy{

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    public int hash(Long k){
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    public int indexFor(int hash, int length){

        return hash & (length - 1);
    }

    public Entry getEntry(Long key){

        int hash = hash(key);
        int index = indexFor(hash, table.length);

        Entry currentEntry = table[index];

        if (currentEntry != null) {
            if (table[index].key.equals(key)) return currentEntry;


            while (currentEntry.next != null) {
                Entry entry = currentEntry.next;

                if (entry.key.equals(key)) return entry;
                currentEntry = currentEntry.next;
            }
        }

        return null;
    }

    public void resize(int newCapacity){
        Entry[] newTable = new Entry[newCapacity];
        if (newTable.length >= table.length) {
            transfer(newTable);
        }
    }

    public void transfer(Entry[] newTable){

        if (newTable.length >= table.length) {
            Entry[] tmpTable = table;
            table = newTable;
            for (int i = 0; i < table.length; i++) {
                Entry currentEntry = tmpTable[i];
                int index = indexFor(currentEntry.hash, table.length);
                addEntry(currentEntry.hash, currentEntry.key, currentEntry.value, index);

                while(currentEntry.next != null){
                    Entry entry = currentEntry.next;
                    addEntry(entry.hash, entry.key, entry.value, indexFor(entry.hash, table.length));
                    currentEntry = currentEntry.next;
                }
            }
        }

    }

    public void addEntry(int hash, Long key, String value, int bucketIndex){

        if (containsKey(key)){
         Entry entry = getEntry(key);
         entry.value = value;
        }
        else {
            Entry e = table[bucketIndex];
            table[bucketIndex] = new Entry(hash, key, value, e);
        }

    }

    public Entry createEntry(int hash, Long key, String value, int bucketIndex){

        return new Entry(hash, key, value, table[bucketIndex]);
    }


    @Override
    public boolean containsKey(Long key) {
        if (getEntry(key) != null) return true;
        else  return false;
    }

    @Override
    public boolean containsValue(String value) {
        for(int i = 0; i <table.length; i++){
            Entry currentEntry = table[i];
            if (currentEntry != null){
                if (currentEntry.value.equals(value)) return  true;

                while(currentEntry.next != null){
                    Entry entry = currentEntry.next;
                    if (entry.value.equals(value)) return  true;
                    currentEntry = currentEntry.next;
                }
            }
        }

        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        addEntry(hash, key, value, index);
    }

    @Override
    public Long getKey(String value) {
        for(int i = 0; i <table.length; i++){
            Entry currentEntry = table[i];
            if (currentEntry != null){
                if (currentEntry.value.equals(value)) return  currentEntry.key;

            while(currentEntry.next != null){
                Entry entry = currentEntry.next;
                if (entry.value.equals(value)) return currentEntry.key;
                currentEntry = currentEntry.next;
             }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        Entry result = getEntry(key);
        if (result != null) return result.value;
        else  return null;

    }
}
