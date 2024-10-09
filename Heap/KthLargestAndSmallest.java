package Heap;

import java.util.PriorityQueue;

public class KthLargestElement {
    //  max heap
    private static PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);

    /*
    * to find kth largest we will have to ignore/remove (k-1) numbers that are larger than kth.
    * So heap size should not exceed a.length-(k-1)=a.length-k+1
    * Hence the formula.
    * */
    public static int KthLargest(int[] a, int k){
        if(k<1 || k>a.length) throw  new IllegalArgumentException();
        for (int i: a){
            heap.add(i);
            if(heap.size() > a.length-k+1)
                heap.poll();
        }
        return heap.remove();
    }
}


public class KthSmallestElement {
    //  min heap
    private static PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)->a-b);

    /*
     * to find kth Smallest we will have to ignore/remove (k-1) numbers that are smaller than kth.
     * So heap size should not exceed a.length-(k-1)=a.length-k+1
     * Hence the formula.
     * */
    public static int KthSmallest(int[] a, int k){
        if(k<1 || k>a.length) throw  new IllegalArgumentException();
        for (int i: a){
            heap.add(i);
            if(heap.size() > a.length-k+1)
                heap.poll();
        }
        return heap.remove();
    }
}
