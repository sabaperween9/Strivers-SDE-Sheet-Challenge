class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int sell = 0;
        int buy = prices[0];
        int profit = 0;

        for(int i = 1; i < n; i++) {
            if(prices[i] < buy) {
                buy = prices[i];
            }else {
                sell = prices[i];
                profit = Math.max(profit , sell - buy);
            }
        }

        return profit;
    }
}

// ================== TC = O(n) ========================================