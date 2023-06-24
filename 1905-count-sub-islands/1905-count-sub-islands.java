class Solution {
    int[] delI = {-1, 0, 1, 0};
    int[] delJ = {0, 1, 0, -1};
    int[][] vis;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length;
        int m = grid2[0].length;
        vis = new int[n][m];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid2[i][j] == 1) {
                    if (dfs(i, j, grid1, grid2)) count++;
                }
            }
        }

        return count;
    }

    public boolean dfs(int i, int j, int[][] grid1, int[][] grid2) {
        if (grid1[i][j] == 0) return false;
        vis[i][j] = 1;

        boolean isSubIsland = true;

        for (int k = 0; k < 4; k++) {
            int ni = i + delI[k];
            int nj = j + delJ[k];

            if (isSafe(ni, nj, grid2.length, grid2[0].length)
            && grid2[ni][nj] == 1
            && vis[ni][nj] == 0) {
                if (!dfs(ni, nj, grid1, grid2)) { 
                    isSubIsland = false;
                }
            }
        }

        return isSubIsland;
    }

    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
}