class Solution {
    int ROW;
    int COL;
    int[] delI = {-1, 0, 1, 0};
    int[] delJ = {0, 1, 0, -1};
    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
    public boolean dfs(int i, int j, int[][] grid) {
        if (i == ROW - 1) return true;

        grid[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int ni = i + delI[k];
            int nj = j + delJ[k];
            if (isSafe(ni, nj, ROW, COL) && grid[ni][nj] == 0) {
                if (dfs(ni, nj, grid)) return true;
            }
        }

        return false;
    } 
    public boolean canCross(int[][] cells, int mid) {
        int[][] grid = new int[ROW][COL];
        for (int i = 0; i <= mid; i++) {
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;

            grid[x][y] = 1;
        }

        for (int j = 0; j < COL; j++) {
            if (grid[0][j] == 0 && dfs(0, j, grid)) {
                return true;
            }
        }

        return false;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        ROW = row;
        COL = col;

        int l = 0;
        int r = cells.length - 1;

        int lastDay = 0;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (canCross(cells, mid)) {
                lastDay = mid + 1;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return lastDay;
    }
}