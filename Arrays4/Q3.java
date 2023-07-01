//========================= Approach-1 TC = O(nlogn) SC = O(1) =====================================================================================
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if(n == 0)
            return 0;
        int ans = 1;
        int count = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i] - nums[i-1] == 1){
                count++;
                if(ans < count)
                    ans = count;
            }else if (nums[i]- nums[i-1] == 0) {
                continue;
            }else {
                count = 1;
            }

        }
        return ans;

    }
}

// ========================Approach - 2 , TC = O(n) , SC = O(n) =====================================================================

class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        int res=1;
        if(n==1) return res;
        HashSet<Integer> hs=new HashSet<>();
        for(int x:nums)
            hs.add(x);
        for(int x:nums){
            int diff=x-1;
            if(!hs.contains(diff)){
                int temp=x+1;
                int count=1;
                while(hs.contains(temp)){
                    count++;
                    temp++;
                }
                res=Math.max(res,count);
            }
        }

        return res;
    }
}