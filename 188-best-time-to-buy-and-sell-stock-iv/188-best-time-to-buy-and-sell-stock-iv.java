class Solution {
    int[][][] dp;
    public int maxProfit(int k, int[] prices) {
        dp = new int[1001][2][101];
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 2; j++) {
                for (int l = 0; l < 101; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        return f(0, 1, k, prices);
    }

    public int f(int i, int canBuy, int k, int[] prices) {
        if (k == 0) return 0;
        if (i == prices.length) return 0;

        if (dp[i][canBuy][k] != -1) return dp[i][canBuy][k];


        int profit = Integer.MIN_VALUE;
        if (canBuy == 1) {
            profit = Math.max(-prices[i] + f(i + 1, 0, k, prices), f(i + 1, 1, k, prices));
        } else {
            profit = Math.max(prices[i] + f(i + 1, 1, k - 1, prices), f(i + 1, 0, k, prices));
        }

        return dp[i][canBuy][k] = profit;
    }
}