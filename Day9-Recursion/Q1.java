//==================== Approach - 1 (return void from helper method) ,TC =O(2^N) ,SC: O(2^N) ===============================
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        if(N == 0)
            return arr;
        int sum = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        helper(arr , N , sum, ans);
        return ans;
    }
    
    void helper(ArrayList<Integer> arr , int N, int sum, ArrayList<Integer> ans) {
        
        if(N == 0) {
           ans.add(sum);
           return;
        }
    
        helper(arr, N - 1, sum + arr.get(N - 1), ans);
        helper(arr, N - 1, sum, ans);   
    }
}


// =================== Approach - 2 (return ArrayList from helper method) ======================================
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        if(N == 0)
            return arr;
        int sum = 0;
        return helper(arr , N , sum);
    }
    
    ArrayList<Integer> helper(ArrayList<Integer> arr , int N, int sum) {
        if(N == 0) {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(sum);
            return al;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        ans.addAll(helper(arr, N - 1, sum + arr.get(N - 1)));
        ans.addAll(helper(arr, N - 1, sum));
        
        return ans;
    }
}