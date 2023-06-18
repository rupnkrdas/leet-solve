class Solution {
    int[] delI = {-1, 0, 1, 0};
    int[] delJ = {0, 1, 0, -1};
    int n;
    int m;
    long[][] dp;
    long MOD = (long)(1e9 + 7);
    public int countPaths(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += solve(i, j, grid)%MOD;
            }
        }

        return (int)(count%MOD);
    }

    public long solve(int i, int j, int[][] grid) {
        if (dp[i][j] != -1) return dp[i][j];

        long paths = 1;
        for (int k = 0; k < 4; k++) {
            int ni = i + delI[k];
            int nj = j + delJ[k];

            if (isSafe(ni, nj) && grid[ni][nj] > grid[i][j]) {
                paths = paths%MOD + solve(ni, nj, grid)%MOD;
            }
        }

        return dp[i][j] = paths%MOD;
    }

    public boolean isSafe(int i, int j) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
}