class Solution {
    int[][] dp = new int[301][11];
    public int minDifficulty(int[] jd, int d) {
        int n = jd.length;

        if (n < d) return -1;

        for (int i = 0; i < 301; i++) {
            for (int j = 0; j < 11; j++) {
                dp[i][j] = -1;
            }
        }

        return f(0, d, n, jd);
    }

    public int f(int idx, int d, int n, int[] arr) {
        if (d == 1) {
            int maxi = Integer.MIN_VALUE;
            for (int i = idx; i < n; i++) {
                maxi = Math.max(maxi, arr[i]);
            }

            return maxi;
        }

        if (dp[idx][d] != -1) {
            return dp[idx][d];
        }

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for (int i = idx; i <= n - d; i++) {
            maxi = Math.max(maxi, arr[i]);
            mini = Math.min(mini, maxi + f(i + 1, d - 1, n, arr));
        }

        return dp[idx][d] = mini;
    }
}