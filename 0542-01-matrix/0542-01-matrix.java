class Solution {
    int N, M;
    int[] delI = {-1, 0, 1, 0};
    int[] delJ = {0, 1, 0, -1};
    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
    public int[][] updateMatrix(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = -1;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[] {i, j, 0});
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] t = q.poll();
                int i = t[0], j = t[1], distance = t[2];
                // dist[i][j] = distance;

                for (int k = 0; k < 4; k++) {
                    int ni = i + delI[k];
                    int nj = j + delJ[k];

                    if (isSafe(ni, nj, N, M)
                    && dist[ni][nj] == -1) {
                        dist[ni][nj] = distance + 1;
                        q.offer(new int[]{ni, nj, dist[ni][nj]});
                    }

                }
            }
        }

        return dist;
    }
}