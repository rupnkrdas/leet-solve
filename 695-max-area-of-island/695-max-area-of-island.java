class Solution {
    int[] delI = {-1, 0, 1, 0};
    int[] delJ = {0, 1, 0, -1};
    int n;
    int m;
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int[][] vis = new int[n][m];

        int maxi = (int)-1e9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int[] area = {0};
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    dfs(i, j, grid, vis, area);
                    System.out.println(area[0]);
                    maxi = Math.max(area[0], maxi);
                }
                area[0] = 0;
            }
        }

        return (maxi != (int)-1e9) ? maxi : 0;

    }

    public void dfs(int i, int j, int[][] grid, int[][] vis, int[] area) {
        vis[i][j] = 1;
        area[0]++;

        for (int k = 0; k < 4; k++) {
            int ni = i + delI[k];
            int nj = j + delJ[k];

            if (ni >= 0 && ni < n
            && nj >= 0 && nj < m
            && vis[ni][nj] == 0
            && grid[ni][nj] == 1) {
                dfs(ni, nj, grid, vis, area);
            }
        }
    }
}