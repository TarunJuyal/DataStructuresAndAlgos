package Heap;

import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> heap = new ArrayList<>();

    private void swap(int childIndex, int parentIndex){
        int child=heap.get(childIndex);
        int parent =heap.get(parentIndex);
        heap.set(childIndex, parent);
        heap.set(parentIndex,child);
    }

    //  find parent, if parent>child swap and bubbleUp again
    private void bubbleUp(int childIndex){
        int parentIndex = (childIndex-1)/2;
        if(heap.get(childIndex)<heap.get(parentIndex)){
            swap(childIndex,parentIndex);
            bubbleUp(parentIndex);
        }
    }

    //  find childIndexes, compare which is smaller ,then swap and bubbledown, repeat
    private void bubbleDown(int parentIndex){
        int leftChildIndex = 2*parentIndex+1;
        int rightChildIndex = 2*parentIndex+2;
        if(leftChildIndex<heap.size() && heap.get(leftChildIndex)< heap.get(parentIndex)){
            swap(leftChildIndex,parentIndex);
            bubbleDown(leftChildIndex);
        }
        if(rightChildIndex<heap.size() && heap.get(rightChildIndex)< heap.get(parentIndex)){
            swap(rightChildIndex,parentIndex);
            bubbleDown(rightChildIndex);
        }
    }

    public void add(int item){
        heap.add(item);
        bubbleUp(heap.size()-1);
    }

    public int remove(){
        swap(0,heap.size()-1);
        int removed = heap.removeLast();
        bubbleDown(0);
        return removed;
    }

    public void print(){
        System.out.println(heap);
    }
}
