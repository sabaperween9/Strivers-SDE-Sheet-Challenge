public class Solution {
    public static int NthRoot(int n, int m) {
        
        int start = 1, end = m;

        while(start <= end) {
            int mid = start + (end - start)/2;
            int res = helper(mid, n, m);
            if(res == 1) 
                return mid;
            else if(res == 0)
                start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }

    static int helper(int mid, int n, int m) {
        long ans = 1;
        for(int i = 1; i <= n; i++) {
            ans *= mid;
            if(ans > m) return 2;
        }
        if(ans == m) return 1;
        return 0;
    }
}
