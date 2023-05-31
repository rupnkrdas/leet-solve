class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // transpose first
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < m; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        for (int j = 0; j < m/2; j++) {
            for(int i = 0; i < n; i++) {
                swap(matrix, i, j, i, m - 1 - j);
            }
        }
    }

    public void swap(int[][] grid, int i1, int j1, int i2, int j2) {
        int temp = grid[i1][j1];
        grid[i1][j1] = grid[i2][j2];
        grid[i2][j2] = temp;
    }
}