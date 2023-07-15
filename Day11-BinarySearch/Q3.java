class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int start = 0,  end = n - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(mid % 2 != 0) mid--;
            if(nums[mid] != nums[mid + 1])
                end = mid;
            else start = mid + 2;
        }
        return nums[start];
    }
}