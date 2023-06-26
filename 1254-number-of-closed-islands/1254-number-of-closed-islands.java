class Solution {
    int[] delI = {-1, 0, 1, 0};
    int[] delJ = {0, 1, 0, -1};
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        for (int[] row : vis) {
            Arrays.fill(row, -1);
        }

        // dfs on top boundary if grid[i][j] == 0
        for(int j = 0; j < m; j++) {
            if (grid[0][j] == 0 && vis[0][j] == -1) {
                dfs(0, j, grid, vis);
            }
        }
        // dfs on left boundary if grid[i][j] == 0
        for(int i = 0; i < n; i++) {
            if (grid[i][0] == 0 && vis[i][0] == -1) {
                dfs(i, 0, grid, vis);
            }
        }
        // dfs on bottom boundary if grid[i][j] == 0
        for(int j = 0; j < m; j++) {
            if (grid[n - 1][j] == 0 && vis[n - 1][j] == -1) {
                dfs(n - 1, j, grid, vis);
            }
        }
        // dfs on right boundary if grid[i][j] == 0
        for(int i = 0; i < n; i++) {
            if (grid[i][m - 1] == 0 && vis[i][m - 1] == -1) {
                dfs(i, m - 1, grid, vis);
            }
        }

        // count dfs traverals if grid[i][j] == 0 && vis[i][j] == -1
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 0 && vis[i][j] == -1) {
                    count++;
                    dfs(i, j, grid, vis);
                }
            }
        }

        return count;
    }

    public void dfs(int i, int j, int[][] grid, int[][] vis) {
        vis[i][j] = 1;

        for (int k = 0; k < 4; k++) {
            int ni = i + delI[k];
            int nj = j + delJ[k];

            if (isSafe(ni, nj, grid.length, grid[0].length)
            && vis[ni][nj] == -1
            && grid[ni][nj] == 0) {
                dfs(ni, nj, grid, vis);
            }
        }
    }

    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }

}