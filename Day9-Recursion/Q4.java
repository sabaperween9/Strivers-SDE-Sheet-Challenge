class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(int[] arr, int index, int target, List<Integer> al, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(al));
            return;
        }
        if(index == arr.length)
            return;
        for(int i = index; i < arr.length; i++) {

            if(i != index && arr[i] == arr[i - 1]) continue;
            if(target >= arr[i]) {
                al.add(arr[i]);
                helper(arr, i + 1, target - arr[i], al, ans);
                al.remove(al.size() - 1);
            }
        }
    } 
}