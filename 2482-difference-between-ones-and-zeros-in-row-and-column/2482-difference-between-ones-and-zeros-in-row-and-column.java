class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        Map<Integer, Integer> onesRow = new HashMap<>();
        Map<Integer, Integer> onesCol = new HashMap<>();

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    onesRow.put(i, onesRow.getOrDefault(i, 0) + 1);
                    onesCol.put(j, onesCol.getOrDefault(j, 0) + 1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = 2 * onesRow.getOrDefault(i, 0) + 2 * onesCol.getOrDefault(j, 0) - (n + m);
            }
        }


        return grid;
    }
}