// =================== Approach-1 (dp memoization) TC = exponentional============================
class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        for(int[] x: dp) 
            Arrays.fill(x , -1);        
        return helper(m - 1, n - 1, dp);
    }

    int helper(int m , int n , int[][] dp) {
        if(m < 0 || n < 0)
            return 0;
        if(m == 0 && n == 0)
            return 1;
        if(dp[m][n] != -1)
            return dp[m][n];
        dp[m][n] = helper(m - 1, n, dp) + helper(m, n - 1, dp);
        return dp[m][n];
    }
}

// ============================Approach - 2 TC = O(m * n) , SC = O(m * n)======================================================

class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0] , 1);
        for(int i = 0; i < m; i++)
            dp[i][0] = 1;
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }       
        return dp[m - 1][n - 1];
    }
}


//==============================Approach-3 , space Optimization ========================================

class Solution {
    public int uniquePaths(int m, int n) {
        
        int[] prev = new int[n];
        Arrays.fill(prev , 1);
        for(int i = 1; i < m; i++) {
            int[] curr = new int[n];
            curr[0] = 1;
            for(int j = 1; j < n; j++){
                curr[j] = curr[j - 1] + prev[j];
            }
            prev = curr;
        }       
        return prev[n - 1];
    }
}

// ==========================Approach-4 , TC = O(m) ==============================================================

class Solution {
    public int uniquePaths(int m, int n) {
        
        int step = m + n - 2;
        int r = m - 1;
        double ans = 1;
        for(int i = 1; i <= r; i++) {
            ans = ans * (step - r + i) /i;
        }
        return (int)ans;
    }
}
