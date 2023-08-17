class Solution {
    int[] delI = {-1, 0, 1, 0};
    int[] delJ = {0, 1, 0, -1};
    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
    public int numEnclaves(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        q.offer(new int[]{i, j});
                        vis[i][j] = 1;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] node = q.poll();
                int i = node[0], j = node[1];

                for (int k = 0; k < 4; k++) {
                    int ni = i + delI[k];
                    int nj = j + delJ[k];

                    if (isSafe(ni, nj, n, m)
                    && vis[ni][nj] == 0
                    && grid[ni][nj] == 1) {
                        vis[ni][nj] = 1;
                        q.offer(new int[] {ni, nj});
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) count++;
            }
        }

        return count;
    }
}