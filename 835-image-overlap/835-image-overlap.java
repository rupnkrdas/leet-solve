class Solution {
    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
    private int count_overlaps(int ro, int co, int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int ni = i + ro;
                int nj = j + co;

                if (isSafe(ni, nj, n, n)) {
                    if (grid1[i][j] == 1 && grid2[ni][nj] == 1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        // row_offset : -n + 1 -> n - 1
        // col_offset : -n + 1 -> n - 1

        int maxi = 0;
        for (int row_offset = -n + 1; row_offset <= n - 1; row_offset++) {
            for (int col_offset = -n + 1; col_offset <= n - 1; col_offset++) {
                maxi = Math.max(maxi, count_overlaps(row_offset, col_offset, img1, img2));
            }
        }

        return maxi;
    }
}