// ==============================TC = O(n) =====================================================================================
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return -1;
        if(n == 2)
            return nums[0] == nums[1] ? nums[0] : -1 ;
        int s = -1;
        int f = -2;
        boolean flag = true;
// ============= Note : instead of using flag we can also use do-while loop ====================================================
        while(s != f) {
            if(flag) {
                s = nums[0];
                f = nums[0];
                flag = false;
            }
            s = nums[s];
            f = nums[nums[f]];
        }
        f = nums[0];
        while(s != f ) {
            s = nums[s];
            f = nums[f];
        }
        return s;
    }
}