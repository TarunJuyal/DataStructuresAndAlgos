package HashMap;

import java.util.LinkedList;

public class MyHashMap<K,V> {
    //  Key-Value Pair class
    private class KeyValuePair<K,V>{
        private K key;
        private V value;

        public KeyValuePair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + "=" + value + "}";
        }
    }

    private static final int DEFAULT_CAPACITY=10;
    private int size;
    //  buckets -> Array of LinkedList
    private LinkedList<KeyValuePair<K,V>>[] buckets;

    public MyHashMap() {
        this.buckets = new LinkedList[DEFAULT_CAPACITY];
    }

    public MyHashMap(int capacity) {
        this.buckets = new LinkedList[capacity];
    }

    private int hashFunction(K key){
        return Math.abs(key.hashCode()) % this.buckets.length;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public void put(K key, V value){
        //  create new key-value pair
        KeyValuePair<K,V> newEntry = new KeyValuePair<>(key,value);
        //  find bucket index and get bucket
        int bucketIndex = hashFunction(key);
        //  check if bucket empty if so create a new linked list
        if(this.buckets[bucketIndex]==null)
            this.buckets[bucketIndex] = new LinkedList<KeyValuePair<K,V>>();
        LinkedList<KeyValuePair<K, V>> bucket = this.buckets[bucketIndex];
        //  check for duplicate key exist if so update
        for(KeyValuePair<K,V> entry: bucket){
            if(entry.key == key){
                entry.value = value;
                return;
            }
        }
        //  if not duplicate add item to last
        bucket.addLast(newEntry);
        this.size++;
    }

    public V get(K key){
        //  find bucket index
        int bucketIndex =  hashFunction(key);
        //  check if bucket exist if exist loop and return element
        LinkedList<KeyValuePair<K, V>> bucket = this.buckets[bucketIndex];
        if(bucket!=null){
            for(KeyValuePair<K,V> entry: bucket){
                if(entry.key==key) return entry.value;
            }
        }
        //  if not found or bucket not exist
        return null;
    }

    public V remove(K key){
        //  find bucket index
        int bucketIndex =  hashFunction(key);
        //  check if bucket exist if exist loop and return element
        LinkedList<KeyValuePair<K, V>> bucket = this.buckets[bucketIndex];
        if(bucket!=null){
            for(KeyValuePair<K,V> entry: bucket){
                if(entry.key==key) {
                    bucket.remove(entry);
                    this.size--;
                    return entry.value;
                }
            }
        }
        //  if not found or bucket not exist
        throw new IllegalStateException();
    }

    public boolean containsKey(K key){
        //  find bucket index
        int bucketIndex =  hashFunction(key);
        //  check if bucket exist if exist loop and return element
        LinkedList<KeyValuePair<K, V>> bucket = this.buckets[bucketIndex];
        if(bucket!=null){
            for(KeyValuePair<K,V> entry: bucket){
                if(entry.key==key) {
                    return true;
                }
            }
        }
        //  if not found or bucket not exist
        return false;
    }

    public void print() {
        for(LinkedList<KeyValuePair<K,V>> bucket : this.buckets) {
            if(bucket!=null) {
                System.out.println(bucket);
            }
        }
    }
}
