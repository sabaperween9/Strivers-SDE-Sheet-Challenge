class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pvt = piviot(nums);
        if(pvt == -1)
            return binarySearch(nums, 0, n - 1, target);
        if(nums[pvt] == target) return pvt;
        if(nums[0] <= target) return binarySearch(nums, 0, pvt - 1, target);
        return binarySearch(nums, pvt + 1, n - 1, target);  
    }
    int piviot(int[] nums) {
        int n = nums.length;
        int s = 0, e = n - 1;
        while(s <= e) {
            int mid = s + (e - s)/2;
            if(mid + 1 <= e && nums[mid] > nums[mid + 1]) 
                return mid + 1;
            if(mid - 1 >= s && nums[mid] < nums[mid - 1])
                return mid;
            if(nums[s] >= nums[mid]) e = mid -1;
            else s = mid + 1;
        }
        return -1;
    }
    int binarySearch(int[] nums, int s, int e, int target) {
        while(s <= e) {
            int mid =  s + (e - s) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                e = mid - 1;
            else s = mid + 1;
        }
        return -1;
    }
}