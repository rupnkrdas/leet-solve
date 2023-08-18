class Solution {
    int N, M;
    int[] delI = {-1, 0, 1, 0};
    int[] delJ = {0, 1, 0, -1};
    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
    private boolean isGood(int i, int j, int[][] grid, int mid, int[][] vis) {
        if (i == N - 1 && j == M - 1) return true;
        vis[i][j] = 1;

        boolean ans = false;
        for (int k = 0; k < 4; k++) {
            int ni = i + delI[k];
            int nj = j + delJ[k];

            if (isSafe(ni, nj, N, M) && (Math.abs(grid[ni][nj] - grid[i][j]) <= mid) && (vis[ni][nj] == 0)) {
                if (isGood(ni, nj, grid, mid, vis)) {
                    ans = true;
                    break;
                }
            }
        }

        return ans;
    }
    public int minimumEffortPath(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        int start = 0;
        int end = (int)(1e6);

        int ans = end;
        int[][] vis;
        while (start <= end) {
            int mid = start + (end - start)/2;

            vis = new int[N][M];
            if (isGood(0, 0, grid, mid, vis)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}