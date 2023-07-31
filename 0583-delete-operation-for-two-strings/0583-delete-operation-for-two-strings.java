class Solution {
    int[][] dp = new int[501][501];
    private int solve(int i, int j, char[] s1, char[] s2, int n, int m) {
        if (i == n && j == m) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (i == n) return dp[i][j] = 1 + solve(i, j + 1, s1, s2, n, m);
        if (j == m) return dp[i][j] = 1 + solve(i + 1, j, s1, s2, n, m);

        if (s1[i] == s2[j]) {
            return dp[i][j] = solve(i + 1, j + 1, s1, s2, n, m);
        }

        int delete_s1 = 1 + solve(i + 1, j, s1, s2, n, m);
        int delete_s2 = 1 + solve(i, j + 1, s1, s2, n, m);

        return dp[i][j] = Math.min(delete_s1, delete_s2);
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, word1.toCharArray(), word2.toCharArray(), n, m);
    }
}