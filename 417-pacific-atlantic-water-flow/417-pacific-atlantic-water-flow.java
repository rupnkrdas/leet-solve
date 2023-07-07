class Solution {
    int[] delI = {-1, 0, 1, 0};
    int[] delJ = {0, 1, 0, -1};
    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] vis_po = new int[n][m];
        int[][] vis_ao = new int[n][m];

        for (int j = 0; j < m; j++) {
            dfs(0, j, heights, vis_po, n, m);
        }
        for (int i = 0; i < n; i++) {
            if (vis_po[i][0] != 1) {
                dfs(i, 0, heights, vis_po, n, m);
            }
        }
        for (int i = 0; i < n; i++) {
            dfs(i, m - 1, heights, vis_ao, n, m);
        }
        for (int j = 0; j < m; j++) {
            if (vis_ao[n-1][j] != 1) {
                dfs(n - 1, j, heights, vis_ao, n, m);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((vis_po[i][j] == 1) && (vis_ao[i][j] == 1)) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    ans.add(pair);
                }
            }
        }

        return ans;
    }

    private void dfs(int i, int j, int[][] grid, int[][] vis, int n, int m) {
        vis[i][j] = 1;

        for (int k = 0; k < 4; k++) {
            int ni = i + delI[k];
            int nj = j + delJ[k];

            if (isSafe(ni, nj, n, m)
            && grid[ni][nj] >= grid[i][j]
            && vis[ni][nj] == 0) {
                dfs(ni, nj, grid, vis, n, m);
            }
        }
    }
}