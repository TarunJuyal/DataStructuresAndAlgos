package Sorting;

public class InsertionSort {

    public static void insertionSort(int[] a){
        for (int i = 1; i < a.length; i++) {
            int currentItem=a[i];
            int j=i-1;
            while(j>=0 && a[j] > currentItem) {
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=currentItem;
        }
    }

    private static int[] insertionSortRecursive(int[] a, int i, int j){
        //  base condition
        if(i==a.length) return a;

        int currentItem=a[i];
        while(j>=0 && a[j]>currentItem) {
            a[j+1]=a[j];
            j--;
        }
        a[j+1]=currentItem;

        return insertionSortRecursive(a,i+1,i);
    }

    public static int[] insertionSortRecursive(int[] a){
        return insertionSortRecursive(a,1,0);
    }
}
