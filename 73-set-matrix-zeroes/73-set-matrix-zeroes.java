class Solution {
    public void setZeroes(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Set<Integer> set = new HashSet<>(); // (stores uniques ids of columns and rows)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               if (grid[i][j] == 0) {
                    int row = i;
                    int col = j + n + 1;

                    set.add(row);
                    set.add(col);
               }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int row = i;
                int col = j + n + 1;
                if (set.contains(row) || set.contains(col)) grid[i][j] = 0;
            }
        }
    }
}