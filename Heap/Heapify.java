package Heap;

public class Heapify {

    private static void swap(int childIndex, int parentIndex, int[] a){
        int temp=a[childIndex];
        a[childIndex]=a[parentIndex];
        a[parentIndex]=temp;
    }

    //  find childIndexes, compare which is bigger ,then swap and bubbledown, repeat
    private static void bubbleDown(int parentIndex, int[] a){
        int leftChildIndex = 2*parentIndex+1;
        int rightChildIndex = 2*parentIndex+2;
        int largest=parentIndex;
        if(leftChildIndex<a.length && a[leftChildIndex]> a[parentIndex])
            largest=leftChildIndex;
        if(rightChildIndex<a.length && a[rightChildIndex]> a[parentIndex])
            largest=rightChildIndex;
        if(largest==parentIndex)
            return;
        swap(largest,parentIndex,a);
        bubbleDown(largest,a);
    }

    /*
    * Optimization:
    * 1:    In Perfect Binary tree half nodes are at last level and no need to heapify for leaf nodes
    *       Find index of node which is lastParent by getting last node index and finding parentindex (childIndex-1)/2
    * 2:    Heapify in reverse order as it will do less recursive calls.
    * */
    public static void heapify(int[] a){
        int lastIndex=a.length-1;
        for(int i=(lastIndex-1)/2;i>=0;i--) {
            bubbleDown(i,a);
        }
    }
}
