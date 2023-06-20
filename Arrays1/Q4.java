class Solution {
public int maxSubArray(int[] nums) {
        int n=nums.length;
// =================Brute force Approach ---------- Tc = O(n2)==================================================
        // int res = Integer.MIN_VALUE;
        // for(int i = 0; i < n; i++) {
        //     int sum = nums[i];
        //     for(int j = i+1; j < n; j++) {
        //         res = Math.max(sum , res);
        //         sum += nums[j];
        //     }
        //     res = Math.max(res , sum);
        // }

        // return res;

//=======================Kadanes's algo  --------  TC = O(n) ===================================================      
        
        int res=nums[0];

        int sum=nums[0];
        for(int i=1;i<n;i++){
            sum=Math.max(sum+nums[i],nums[i]);
            res=Math.max(sum,res);
        }
        return res;
    }
}