class Solution {
    private int MOD = (int)(1e9 + 7);

    private int f(int n, int k, int TARGET) {
        int[][] dp = new int[31][10001];
        for (int idx = 0; idx < n; idx++) {
            for (int target = 0; target <= TARGET; target++) {
                if (idx == 0) {
                    dp[idx][target] = (target >= 1 && target <= k) ? 1 : 0;
                    continue;
                }

                int ways = 0;
                for (int i = 1; i <= k; i++) {
                    if (i <= target) ways = (ways)%MOD + dp[idx - 1][target - i]%MOD;
                }

                dp[idx][target] = ways%MOD;
            }
        }

        return dp[n - 1][TARGET];
    }
    public int numRollsToTarget(int n, int k, int target) {
        return f(n, k, target)%MOD;
    }
}