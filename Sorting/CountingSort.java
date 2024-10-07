package Sorting;

public class CountingSort {
    private static int maxValue(int[] a){
        int max=Integer.MIN_VALUE;
        for(int i: a){
            if(i>max) max=i;
        }
        return max;
    }

    public static void countSort(int[] a){
        int[] counts=new int[maxValue(a)+1];
        for(int i: a)
            counts[i]++;
        int k=0;
        for(int i=0;i<counts.length;i++) {
            for(int j=0;j<counts[i];j++)
                a[k++]=i;
        }
    }
}
