package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy{

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize;

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

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

        Entry currentEntry = null;
        if (table[index] != null) currentEntry = table[index].getEntry();

        if (currentEntry != null) {
            if (currentEntry.getKey().equals(key)) return currentEntry;


            while (currentEntry.next != null) {
                Entry entry = currentEntry.next;

                if (entry.key.equals(key)) return entry;
                currentEntry = currentEntry.next;
            }
        }

        return null;
    }

    public void resize(int newCapacity){
        FileBucket[] newTable = new FileBucket[newCapacity];
        if (newTable.length >= table.length) {
            transfer(newTable);
        }
    }

    public void transfer(FileBucket[] newTable){

        if (newTable.length >= table.length) {
            FileBucket[] tmpTable = table;
            table = newTable;
            for (int i = 0; i < table.length; i++) {
                Entry currentEntry = tmpTable[i].getEntry();
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
            if (table[bucketIndex] != null) {
                Entry e = table[bucketIndex].getEntry();
                table[bucketIndex].putEntry(new Entry(hash, key, value, e));
            }
            else {
                table[bucketIndex] = new FileBucket();
                table[bucketIndex].putEntry(new Entry(hash, key, value, null));
            }

        }

    }

    public Entry createEntry(int hash, Long key, String value, int bucketIndex){

        return new Entry(hash, key, value, table[bucketIndex].getEntry());
    }


    @Override
    public boolean containsKey(Long key) {
        if (getEntry(key) != null) return true;
        else  return false;
    }

    @Override
    public boolean containsValue(String value) {
        for(int i = 0; i <table.length; i++) {
            if (table[i] != null) {
                Entry currentEntry = table[i].getEntry();
                if (currentEntry != null) {
                    if (currentEntry.value.equals(value)) return true;

                    while (currentEntry.next != null) {
                        Entry entry = currentEntry.next;
                        if (entry.value.equals(value)) return true;
                        currentEntry = currentEntry.next;
                    }
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
            Entry currentEntry = null;
            if (table[i] != null) currentEntry = table[i].getEntry();
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
