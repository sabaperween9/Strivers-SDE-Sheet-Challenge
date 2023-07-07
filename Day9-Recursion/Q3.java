
// =================== TC = O(2^t * k) ==================================================
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    void helper(int[] arr, int index, int target, List<Integer> al, List<List<Integer>> ans) {

        if(target == 0) {
           ans.add(new ArrayList(al));
           return; 
        }

        if(index == arr.length)
            return;
        
        for(int i = index; i < arr.length; i++) {
            if(target >= arr[i]) {
                al.add(arr[i]);
                helper(arr, i, target - arr[i], al, ans);
                al.remove(al.size() - 1);
            }
        }

    }
    
}