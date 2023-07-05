class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int n = nums.length;
        int i = 0 , j = 0;
        int ans = Integer.MIN_VALUE;
        for(; j < n; j++) {
            if(nums[j] != 1) {
                ans = Math.max(ans , j - i);
                i = j + 1;
            }
        }
        ans = Math.max(ans , j - i);
        return ans;
    }
}