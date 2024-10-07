package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    private static int maxValue(int[] a){
        int max=Integer.MIN_VALUE;
        for(int i: a){
            if(i>max) max=i;
        }
        return max;
    }

    public static void sort(int[] a) {
        int i=0;
        for(List<Integer> bucket : createBuckets(a,((int)maxValue(a)*a.length)+1)) {
            Collections.sort(bucket);
            for(int item:bucket)
                a[i++]=item;
        }
    }
    private static List<List<Integer>> createBuckets(int[] a,int numberOfBuckets){
        List<List<Integer>> buckets=new ArrayList<>();
        for(int i=0;i<numberOfBuckets;i++)
            buckets.add(new ArrayList<>());
        for(int item:a)
            buckets.get((int)item*a.length).add(item);
        return buckets;
    }
}
