// ========================Approach - 1 , TC = O(n^2) , SC = O(n) ===================================================================
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int x : nums)
            hm.put(x , hm.getOrDefault(x , 0) + 1);
        
        for(Map.Entry<Integer , Integer> e : hm.entrySet()){
            if(e.getValue() > n/2) {
                ans = e.getKey();
                break;
            }
        }
        return ans;
   }

}

// ======================================= Approach - 2 , TC = O(n) , SC = O(1) ========================================================================
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int index = 0;
        int count = 1;

        for(int i = 1; i < n; i++) {
            if(nums[i] == nums[index]) 
                count++;
            else count--;
            if(count == 0) {
                count = 1;
                index = i;
            }
        }

        return nums[index];
   }
}
