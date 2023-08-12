class Solution {
    int[][] dp = new int[101][101];
    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
    private int f(int i, int j, int[][] grid, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return (grid[i][j] != 1) ? 1 : 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = 0;
        int nj = j + 1;
        if (isSafe(i, nj, n, m) && grid[i][nj] != 1) {
            right += f(i, nj, grid, n, m);
        }

        int down = 0;
        int ni = i + 1;
        if (isSafe(ni, j, n, m) && grid[ni][j] != 1) {
            down += f(ni, j, grid, n, m);
        }


        return dp[i][j] = right + down;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        if (grid[0][0] == 1) return 0;
        int n = grid.length, m = grid[0].length;
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f(0, 0, grid, n, m);
    }
}