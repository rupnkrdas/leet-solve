class Solution {
    public List<List<Integer>> generate(int numRows) {
        int n = numRows;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            grid[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i - 1][j - 1];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                list.add(grid[i][j]);
            }
            ans.add(new ArrayList<>(list));
        }

        return ans;
    }
}