class Solution {
    public void sortColors(int[] nums) {
        
        int n = nums.length;
        int t0 = 0 , t1 = 0 , t2 = n - 1;
        while(t0 < n && nums[t0] == 0) {
            t0++;
            t1++;
        }
        while(t2 > 0 && nums[t2] == 2) {
            t2--;
        }
        while(t1 <= t2) {
            if(nums[t1] == 0) {
                swap(nums , t0, t1);
                t1++;
                t0++;
            }
            else if(nums[t1] == 1)
                t1++;
            else {
                swap(nums , t1, t2);
                t2--;
            }
        }
    }

    void swap(int[] arr , int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}