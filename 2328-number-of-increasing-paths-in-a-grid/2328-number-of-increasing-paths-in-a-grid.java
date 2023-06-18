class Solution {
    int[] delI = {-1, 0, 1, 0};
    int[] delJ = {0, 1, 0, -1};
    int n;
    int m;
    long MOD = (long)(1e9 + 7);
    Map<String, Long> map = new HashMap<>();
    public int countPaths(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count++;
                count += dfs(i, j, grid) % MOD;
            }
        }

        return (int)(count % MOD);
    }

    public long dfs(int i, int j, int[][] grid) {
        String key = Integer.toString(i) + "," + Integer.toString(j);
        if (map.containsKey(key)) {
            return map.get(key) % MOD;
        }

        long count = 0;
        for (int k = 0; k < 4; k++) {
            int ni = i + delI[k];
            int nj = j + delJ[k];

            if (ni >= 0 && ni < n
            && nj >= 0 && nj < m
            && grid[ni][nj] < grid[i][j]) {
                count += 1 + dfs(ni, nj, grid) % MOD;
            }
        }

        map.put(key, count % MOD);
        return count % MOD;
    }
}