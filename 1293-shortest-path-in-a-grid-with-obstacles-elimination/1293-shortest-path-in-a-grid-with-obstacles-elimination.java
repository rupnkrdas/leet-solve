class Solution {
    int[] delI = {-1, 0, 1, 0};
    int[] delJ = {0, 1, 0, -1};
    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
    public int shortestPath(int[][] grid, int K) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] vis = new int[n][m][n*m + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, K});
        vis[0][0][K] = 1;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] node = q.poll();
                int i = node[0];
                int j = node[1];
                int k = node[2];
                
                if (i == n - 1 && j == m - 1) return steps;

                for (int d = 0; d < 4; d++) {
                    int ni = i + delI[d];
                    int nj = j + delJ[d];

                    if (isSafe(ni, nj, n, m)) {
                        if (grid[ni][nj] == 0 && vis[ni][nj][k] == 0) {
                            vis[ni][nj][k] = 1;
                            q.offer(new int[]{ni, nj, k});
                        } else if (grid[ni][nj] == 1 && k > 0 && vis[ni][nj][k - 1] == 0) {
                            vis[ni][nj][k - 1] = 1;
                            q.offer(new int[]{ni, nj, k - 1});
                        }
                    }
                }

            }

            steps++;
        }

        return -1;
    }
}