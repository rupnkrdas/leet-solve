class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, s, t);
    }

    public int f(int i, int j, String s1, String s2) {
        if (j == s2.length()) {
            return 1;
        }
        if (i == s1.length() && j != s2.length()) return 0; 

        if (dp[i][j] != -1) return dp[i][j];
        
        int take = 0;
        int notTake = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            take = f(i + 1, j + 1, s1, s2); // take
            notTake = f(i + 1, j, s1, s2); // not-take
        } else {
            // cannot take
            notTake = f(i + 1, j, s1, s2);
        }

        return dp[i][j] = take + notTake;
    }
}