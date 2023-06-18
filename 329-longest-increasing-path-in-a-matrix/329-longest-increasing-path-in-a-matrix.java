class Solution {
    int[] delI = {-1, 0, 1, 0};
    int[] delJ = {0, 1, 0, -1};
    int n;
    int m;
    int[][] dp;
    public int longestIncreasingPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxi = Math.max(maxi, dfs(i, j, grid) + 1);
            }
        }

        return maxi;
    }

    public int dfs(int i, int j, int[][] grid) {
        if (dp[i][j] != -1) return dp[i][j];

        int pathLength = 0;
        for (int k = 0; k < 4; k++) {
            int ni = i + delI[k];
            int nj = j + delJ[k];

            if (ni >= 0 && ni < n
            && nj >= 0 && nj < m
            && grid[ni][nj] < grid[i][j]) {
                pathLength = Math.max(pathLength, 1 + dfs(ni, nj, grid));
            }
        }

        return dp[i][j] = pathLength;
    }
}