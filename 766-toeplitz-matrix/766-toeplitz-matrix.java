class Solution {
    public boolean isToeplitzMatrix(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>(); // (key) -> (num)
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int key = i - j;
                int num = grid[i][j];
                if (map.containsKey(key)) {
                    if (map.get(key) != num) return false;
                } else {
                    map.put(key, num);
                }
            }
        }

        return true;
    }
}