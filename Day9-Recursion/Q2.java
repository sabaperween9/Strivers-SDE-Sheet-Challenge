// ================ TC = O(2^n) ====================================================
class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums , 0 , new ArrayList<>() , ans);
        return ans;
    }

    public void helper( int[] nums , int index  , List<Integer> al , List<List<Integer>> list ) {
        list.add(new ArrayList<>(al));
        for(int i = index; i < nums.length; i++) {
            if(i != index && nums[i] == nums[i - 1]) continue;
            al.add(nums[i]);
            helper(nums, i + 1, al, list);
            al.remove(al.size() - 1);
        }
    }
}