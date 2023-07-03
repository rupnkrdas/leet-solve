class Solution {
    int[] delI = {-1, 0};
    int[] delJ = {0, -1};
    int[][] dp;
    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, m - 1, grid);
    }

    public int f(int i, int j, int[][] grid) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        if (dp[i][j] != -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for (int k = 0; k < 2; k++) {
            int ni = i + delI[k];
            int nj = j + delJ[k];

            if (isSafe(ni, nj, grid.length, grid[0].length)) {
                int op = grid[i][j] + f(ni, nj, grid);
                mini = Math.min(mini, op);
            }
        }

        return dp[i][j] = mini;
    }
}