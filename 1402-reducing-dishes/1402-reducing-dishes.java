class Solution {
    int[][] dp;
    public int maxSatisfaction(int[] sat) {
        int n = sat.length;
        dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        Arrays.sort(sat);
        return f(0, 1, sat);
    }

    public int f(int idx, int time, int[] sat) {
        if (idx == sat.length) return 0;

        if (dp[idx][time] != -1) return dp[idx][time];

        int maxi = 0;
        int take = time * sat[idx] + f(idx + 1, time + 1, sat);
        int notTake = 0 + f(idx + 1, time, sat);

        maxi = Math.max(maxi, Math.max(take, notTake));
        return dp[idx][time] = maxi;
    }
}