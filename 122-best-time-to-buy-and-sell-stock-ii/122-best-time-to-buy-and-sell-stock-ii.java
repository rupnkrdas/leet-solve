class Solution {
    public int maxProfit(int[] prices) {
        return f(prices);
    }
    
    public int f(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        
        for (int i = n; i >= 0; i--) {
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                if (i == n) {
                    dp[i][canBuy] = 0;
                    continue;
                }
                
                if (canBuy == 0) {
                    dp[i][canBuy] = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);
                } else {
                    dp[i][canBuy] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
                }
            }
        }
        
        return dp[0][1];
    }
}