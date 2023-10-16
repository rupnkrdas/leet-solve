class Solution {
    public List<Integer> getRow(int rowIndex) {
        int N = 34;
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int[][] grid = new int[rowIndex + 1][rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            grid[i][0] = 1;
        }

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 1; j <= i; j++) {
                grid[i][j] = grid[i - 1][j - 1] + grid[i - 1][j];
                if (i == rowIndex) {
                    res.add(grid[i][j]);
                }
            }
        }

        return res;

    }
}