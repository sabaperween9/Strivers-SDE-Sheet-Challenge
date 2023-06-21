import java.util.* ;
import java.io.*; 
// ============================TC = O(nlogn) , SC = O(n) ==============================================================
public class Solution {
    public static long getInversions(long arr[], int n) {
       
        return mergeSort(arr , 0 , n - 1);

    }

    static long mergeSort(long[] arr, int start, int end) {
        long count = 0;
        if(start < end) {
            int mid = start + (end - start)/2;
            count += mergeSort(arr, start, mid);
            count += mergeSort(arr, mid + 1, end);
            count += merge(arr , start , mid , end);
        }
        return count;
    }

    static long merge(long[] arr, int start,int mid,int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        long[] arr1 = new long[n1];
        long[] arr2 = new long[n2];
        for(int i = 0; i < n1; i++) 
            arr1[i] = arr[i+start];
        for(int i = 0; i < n2; i++) 
            arr2[i] = arr[i + mid + 1];
        int i = 0 , j = 0 , k = start;
        long count = 0;
        while(i < n1 && j < n2) {

            if(arr1[i] <= arr2[j]) 
                arr[k++] = arr1[i++];
            else {
                arr[k++] = arr2[j++];
                count += n1 - i;
            }
        } 

        while(i < n1)
            arr[k++] = arr1[i++];
        while(j < n2)
            arr[k++] = arr2[j++];

        return count;
    }
}