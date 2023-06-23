// ==============================Approach -1 , TC = O(n) , SC = O(n)========================================================
class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++) {
            int diff = target - nums[i];
            if(hm.containsKey(diff)) {
                return new int[]{hm.get(diff),i};
            }
            hm.put(nums[i],i);
        }
        return new int[]{-1 , -1};

    }
}

// ============================Approach -2 , TC = O(n) , SC = O(n) ==========================================================================

class Solution {
    public int[] twoSum(int[] nums, int target) {

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            temp.add(i);
            al.add(temp);
        }
        Collections.sort(al , (a , b) -> a.get(0) - b.get(0));
        int left = 0 , right = nums.length - 1;
        while(left < right) {
            int sum = al.get(left).get(0) + al.get(right).get(0);
            if(sum == target)
                return new int[]{al.get(left).get(1),al.get(right).get(1)};
            else if (sum > target)
                right--;
            else left++;
        }

        return new int[]{-1 , -1};
    }
}
