package Sorting;

public class MergeSort {

    private static void merge(int[] left, int[] right, int[] a){
        int i=0,j=0,k=0;
        //  fill in whichever is lower
        while(i<left.length && j< right.length){
            if(left[i]<=right[j]){
                a[k++]=left[i++];
            }else{
                a[k++]=right[j++];
            }
        }
        // fill the rest
        while(i < left.length)
            a[k++]=left[i++];
        while(j < right.length)
            a[k++]=right[j++];
    }

    public static void mergeSort(int[] a){
        if(a.length<2) return;

        //  divide in half
        int mid=a.length/2;
        int[] left = new int[mid];
        int[] right = new int[a.length-mid];

        // fill the halves
        for(int i=0;i<mid;i++) {
            left[i]=a[i];
        }
        for(int i=mid;i<a.length;i++) {
            right[i-mid]=a[i];
        }

        //  sort the halves
        mergeSort(left);
        mergeSort(right);

        //merge
        merge(left,right,a);
    }
}
