class Solution {
    int[][] dp = new int[301][5001];
    private int f(int idx, int[] coins, int amount) {
        if (idx == 0) {
            return (amount%coins[idx] == 0) ? 1 : 0;
        }
        
        if (dp[idx][amount] != -1) return dp[idx][amount];

        int take = 0;
        if (coins[idx] <= amount) take = f(idx, coins, amount - coins[idx]);
        int notTake = f(idx - 1, coins, amount);

        return dp[idx][amount] = take+notTake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, coins, amount);
    }
}