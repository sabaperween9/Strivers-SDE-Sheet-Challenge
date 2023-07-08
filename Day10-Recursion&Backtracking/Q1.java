// ======================= Permutation of String ===============================================

public class Solution {
    public static List<String> findPermutations(String s) {
        List<String> ans = new ArrayList<>();
        helper("", s, ans);
        return ans;
    }

    static void helper(String p, String s, List<String> ans) {
        if(s.isEmpty()) {
            ans.add(p);
            return;
        }
        char ch = s.charAt(0);
        for(int i = 0; i <= p.length(); i++) {
            String p1 = p.substring(0,i);
            String p2 = p.substring(i , p.length());
            helper(p1+ch+p2, s.substring(1), ans);
        }
    }
}

//  ====================== permutation of Array Approach - 1 =======================================================
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }
    void helper(int[] nums, boolean isVisited[],List<Integer> al, List<List<Integer>> ans) {

        if(al.size() == nums.length) {
            ans.add(new ArrayList<>(al));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(isVisited[i]) continue;
            isVisited[i] = true;
            al.add(nums[i]);
            helper(nums, isVisited, al, ans);
            al.remove(al.size() - 1);
            isVisited[i] = false;
        }
    }
}

// ====================== Approach - 2 ===========================================

class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>>  ans = new ArrayList<>();
         helper(0, nums, ans);
         return ans;
    }

    void helper(int index, int[] nums, List<List<Integer>> ans) {
        if(index == nums.length - 1) {
            List<Integer> al = new ArrayList<>();
            for(int x : nums)
                al.add(x);
            ans.add(new ArrayList<>(al));
            return;
        }

        for(int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            helper(index + 1, nums, ans);
            swap(nums, index, i);
        }

    }
    
    void swap(int[] nums, int index, int i) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }

}