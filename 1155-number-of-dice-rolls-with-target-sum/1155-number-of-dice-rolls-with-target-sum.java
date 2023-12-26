class Solution {
    private int MOD = (int)(1e9 + 7);
    int K = 0;
    int[][] dp = new int[31][10001];
     private int f(int idx, int target) {
        if (idx == 0) {
            return (target >= 1 && target <= K) ? 1 : 0;
        }

        if (dp[idx][target] != -1) return dp[idx][target];


        int ways = 0;
        for (int i = 1; i <= K; i++) {
            if (i <= target) ways = (ways)%MOD + f(idx - 1, target - i)%MOD;
        }

        return dp[idx][target] = ways%MOD;
    }
    public int numRollsToTarget(int n, int k, int target) {
        K = k;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return f(n - 1, target)%MOD;
    }
}