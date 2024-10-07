package Sorting;

public class BubbleSort {

    private static void swap(int[] a,int index1, int index2){
        int temp = a[index1];
        a[index1]=a[index2];
        a[index2]=temp;
    }

    //  iterative
    public static void bubbleSort(int[] a){
        for (int i = 0; i < a.length; i++) {
            boolean isSorted=true;
            for (int j = 1; j < a.length-i; j++) {
                if(a[j]<a[j-1]) {
                    swap(a,j,j-1);
                    isSorted=false;
                }
            }
            if(isSorted) return;
        }
    }

    //  using recursion
    private static int[] bubbleSortRecursion(int[] a, int first, int last){
        //  base condition: when all iteration complete
        if(last==0) return a;
        //  base condition: when current iteration complete
        if(first==last) return bubbleSortRecursion(a,0,last-1);
        if(a[first]>a[first+1]) {
            swap(a,first,first+1);
        }
        return bubbleSortRecursion(a,first+1,last);
    }

    public static int[] bubbleSortRecursion(int[] a){
        return bubbleSortRecursion(a,0,a.length-1);
    }
}
