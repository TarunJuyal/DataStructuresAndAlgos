package HashSet;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashSet<T> {
    //  Key-Value Pair class
    private class KeyValuePair<T>{
        private T key;
        private Integer value;

        public KeyValuePair(T key) {
            this.key = key;
            this.value = null;
        }

        @Override
        public String toString() {
            return key+"";
        }
    }

    private static final int DEFAULT_CAPACITY=10;
    private int size;
    //  buckets -> Array of LinkedList
    private LinkedList<KeyValuePair<T>>[] buckets;

    public MyHashSet() {
        this.buckets = new LinkedList[DEFAULT_CAPACITY];
    }

    public MyHashSet(int capacity) {
        this.buckets = new LinkedList[capacity];
    }

    private int hashFunction(T key){
        return Math.abs(key.hashCode()) % this.buckets.length;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public void add(T key){
        //  create new key-value pair
        KeyValuePair<T> newEntry = new KeyValuePair<>(key);
        //  find bucket index and get bucket
        int bucketIndex = hashFunction(key);
        //  check if bucket empty if so create a new linked list
        if(this.buckets[bucketIndex]==null)
            this.buckets[bucketIndex] = new LinkedList<KeyValuePair<T>>();
        LinkedList<KeyValuePair<T>> bucket = this.buckets[bucketIndex];
        //  check for duplicate key exist if so update
        for(KeyValuePair<T> entry: bucket){
            if(entry.key == key){
                return;
            }
        }
        //  if not duplicate add item to last
        bucket.addLast(newEntry);
        this.size++;
    }

    public T remove(T key){
        //  find bucket index
        int bucketIndex =  hashFunction(key);
        //  check if bucket exist if exist loop and return element
        LinkedList<KeyValuePair<T>> bucket = this.buckets[bucketIndex];
        if(bucket!=null){
            for(KeyValuePair<T> entry: bucket){
                if(entry.key==key) {
                    bucket.remove(entry);
                    this.size--;
                    return entry.key;
                }
            }
        }
        //  if not found or bucket not exist
        throw new IllegalStateException();
    }

    public boolean contains(T key){
        //  find bucket index
        int bucketIndex =  hashFunction(key);
        //  check if bucket exist if exist loop and return element
        LinkedList<KeyValuePair<T>> bucket = this.buckets[bucketIndex];
        if(bucket!=null){
            for(KeyValuePair<T> entry: bucket){
                if(entry.key==key) {
                    return true;
                }
            }
        }
        //  if not found or bucket not exist
        return false;
    }

    @Override
    public String toString(){
        ArrayList<T> a = new ArrayList<>();
        for(LinkedList<KeyValuePair<T>> bucket : this.buckets) {
            if(bucket!=null) {
                for(KeyValuePair<T> entry: bucket)
                    a.add(entry.key);
            }
        }
        return a.toString();
    }
}
