class Solution {
    int[] dp = new int[1001];
    private int f(int idx, int[] cost) {
        if (idx >= cost.length) return 0;

        if (dp[idx] != -1) return dp[idx];

        int oneStep = cost[idx] + f(idx + 1, cost);
        int twoStep = cost[idx] + f(idx + 2, cost);

        return dp[idx] = Math.min(oneStep, twoStep);
    }
    public int minCostClimbingStairs(int[] cost) {
        Arrays.fill(dp, -1);
        return Math.min(f(0, cost), f(1, cost));
    }
}