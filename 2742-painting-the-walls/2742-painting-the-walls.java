class Solution {
    int[][] dp;
    // Map<String, Integer> dp = new HashMap<>();
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return f(0, cost, time, n);
    }

    public int f(int i, int[] cost, int[] time, int wallsRemaining) {
        if (wallsRemaining <= 0) {
            return 0;
        }
        if (i == cost.length) {
            return (int)1e9;
        }

        // String key = Integer.toString(i) + "," + Integer.toString(wallsRemaining);
        // if (dp.containsKey(key)) {
        //     return dp.get(key);
        // }
        if (dp[i][wallsRemaining] != -1) return dp[i][wallsRemaining];

        int take = cost[i] + f(i + 1, cost, time, wallsRemaining - time[i] - 1);
        int notTake = f(i + 1, cost, time, wallsRemaining);

        // int ans = Math.min(take, notTake);
        // dp.put(key, ans);
        // return ans;
        return dp[i][wallsRemaining] = Math.min(take, notTake);
    }
}