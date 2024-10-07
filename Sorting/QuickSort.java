package Sorting;

public class QuickSort {

    private static void swap(int[] a,int first,int second) {
        int temp=a[first];
        a[first]=a[second];
        a[second]=temp;
    }

    private static int partition(int[] a,int start,int end) {
        int boundary=start-1,pivot=a[end];
        //  if current lower than pivot swap with boundary
        for(int i=start;i<=end;i++)
            if(a[i]<=pivot)
                swap(a, i, ++boundary);
        return boundary;
    }

    public static void quickSort(int[] a){
        quickSort(a,0,a.length-1);
    }

    private static void quickSort(int[] a,int start,int end){
        //  base condition
        if(start>=end)
            return;

        int boundary=partition(a,start,end);
        // sort in partitions
        quickSort(a, start, boundary-1);
        quickSort(a,boundary,end);
    }
}
