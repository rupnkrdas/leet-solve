class Tuple {
    int first;
    int second;
    int third;

    public Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    int[] delI = {-1, 0, 1, 0};
    int[] delJ = {0, 1, 0, -1};
    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        int[][] vis = new int[n][n];

        Queue<Tuple> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    vis[i][j] = 1;
                    q.offer(new Tuple(i, j, 0));
                }
            }
        }
        if (q.size() == n*n || q.isEmpty()) return -1;
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            int i = t.first;
            int j = t.second;
            int distance = t.third;
            dist[i][j] = distance;

            for (int k = 0; k < 4; k++) {
                int ni = i + delI[k];
                int nj = j + delJ[k];

                if (isSafe(ni, nj, n, n)
                && vis[ni][nj] == 0) {
                    vis[ni][nj] = 1;
                    q.offer(new Tuple(ni, nj, distance + 1));
                }
            }
        }

        int maxi = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    maxi = Math.max(maxi, dist[i][j]);
                }
            }
        }

        return maxi;
    }
}