package Sorting;

public class SelectionSort {

    private static void swap(int[] a,int index1, int index2){
        int temp = a[index1];
        a[index1]=a[index2];
        a[index2]=temp;
    }

    public static void selectionSort(int[] a){
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i; j < a.length; j++) {
                if(a[j]<a[minIndex]) minIndex=j;
            }
            swap(a,i,minIndex);
        }
    }

    private static int[] selectionSortRecursive(int[] a, int i, int j, int min){
        //  base condition: outer loop
        if(i==a.length) {
            return a;
        }
        //  base condition: inner loop
        if(j==a.length) {
            swap(a,i,min);
            return selectionSortRecursive(a,i+1,i+2,i+1);
        }
        //  find min index inner loop
        if(a[j]<a[min])
            min=j;
        return selectionSortRecursive(a, i, j+1,min);
    }

    public static int[] selectionSortRecursive(int[] a){
        return selectionSortRecursive(a,0,1,0);
    }
}
