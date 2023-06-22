class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0 , n - 1);
    }

    void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
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
    }

    public  int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i]/2.0 > arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    public  int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2 ;
            count += mergeSort(arr, low, mid);  
            count += mergeSort(arr, mid + 1, high); 
            count += countPairs(arr, low, mid, high); 
            merge(arr, low, mid, high);  
        }
        
        return count;
    }
}