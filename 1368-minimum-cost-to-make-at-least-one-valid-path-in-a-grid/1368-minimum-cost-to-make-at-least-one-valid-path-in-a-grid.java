class Solution {
    int[] delI = {-1, 0, 1, 0};
    int[] delJ = {0, 1, 0, -1};
    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
    public int minCost(int[][] grid) {
        int n = grid.length,
            m = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[2] - p2[2]);
        pq.offer(new int[]{0, 0, 0});

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int i = node[0];
            int j = node[1];
            int distance = node[2];
            int dir = grid[i][j];
            int nextI = i;
            int nextJ = j;
            if (dir == 1) {
                // right
                nextJ++;
            } else if (dir == 2) {
                // left
                nextJ--;
            } else if (dir == 3) {
                // down
                nextI++;
            } else {
                // up
                nextI--;
            }

            for (int k = 0; k < 4; k++) {
                int ni = i + delI[k];
                int nj = j + delJ[k];

                if (isSafe(ni, nj, n, m)) {
                    if (ni == nextI && nj == nextJ) {
                        if (distance < dist[ni][nj]) {
                            dist[ni][nj] = distance;
                            pq.offer(new int[]{ni, nj, distance});
                        }
                    } else {
                        if (distance + 1 < dist[ni][nj]) {
                            dist[ni][nj] = distance + 1;
                            pq.offer(new int[]{ni, nj, distance + 1});
                        }
                    }
                }
            }
        }

        for (int[] row : dist) {
            System.out.println(Arrays.toString(row));
        }
        return dist[n-1][m-1];
    }
}