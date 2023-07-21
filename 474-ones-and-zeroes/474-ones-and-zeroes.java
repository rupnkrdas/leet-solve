class Solution {
    Map<Integer, int[]> map = new HashMap<>(); // idx -> {zeroes, ones}
    int[][][] dp;
    private int f(int idx, int m, int n, int len) {
        if (idx == len) {
            return 0;
        }

        if (dp[idx][m][n] != -1) return dp[idx][m][n];

        // take
        int take = 0;
        if (map.get(idx)[0] <= m && map.get(idx)[1] <= n) {
            take = 1 + f(idx + 1, m - map.get(idx)[0], n - map.get(idx)[1], len);
        }

        // not_take
        int not_take = f(idx + 1, m, n, len);

        return dp[idx][m][n] = Math.max(take, not_take);
    }
    private void count_zeroes_ones(char[] s, int idx) {
        int n = s.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(idx)) {
                int[] pair = map.get(idx);
                pair[s[i] - '0']++;
            } else {
                int[] pair = {0, 0};
                pair[s[i] - '0']++;
                map.put(idx, pair);
            }
        }
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;

        dp = new int[len + 1][m + 1][n + 1];
        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            count_zeroes_ones(strs[i].toCharArray(), i);
        }

        return f(0, m, n, len);
    }
}