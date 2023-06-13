class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = 0; j < n; j++) {
                str += String.valueOf(grid[i][j]) + "-";
            }
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (int j = 0; j < n; j++) {
            String str = "";
            for (int i = 0; i < n; i++) {
                str += String.valueOf(grid[i][j]) + "-";
            }
            if (map.containsKey(str)) count += map.get(str);
        }

        System.out.println(map.toString());
        return count;
    }
}