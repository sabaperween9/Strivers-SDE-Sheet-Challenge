// ==================================== TC = O(nlogn + n^2) , SC = O(no. unique triplet)==================================
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(n < 3) return ans;
        Arrays.sort(nums);
        for(int i = 0; i + 2 < n; i++) {
           int j = i + 1, k = n - 1;
           while(j < k) {
               int sum = nums[j] + nums[k];
               if(sum == -nums[i]) {
                   List<Integer> al = new ArrayList<>();
                   al.add(nums[i]);
                   al.add(nums[j]);
                   al.add(nums[k]);
                    ans.add(al);
                    while(j + 1 < n && nums[j] == nums[j + 1]) j++;
                    while(k - 1 > j && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--; 
               }else if(sum < -nums[i]) j++;
               else k--;
           }

           while(i + 1 < n && nums[i] == nums[i + 1]) i++;
        }
        return ans;
    }
}