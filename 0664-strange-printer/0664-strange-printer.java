class Solution {
    int[][] dp;
    int n;
    private int solve(int l, int r, char[] s) {
        if (l == r) return 1;
        if (l > r) return 0;

        if (dp[l][r] != -1) return dp[l][r];

        int i = l + 1;
        while (i <= r && s[i] == s[l]) {
            i++;
        }

        if (i == r + 1) return 1;

        // s[i] != s[l]
        int op1 = 1 + solve(i, r, s);

        int greed = Integer.MAX_VALUE;
        for (int j = i + 1; j <= r; j++) {
            if (s[j] == s[l]) {
                int op2 = solve(i, j - 1, s) + solve(j, r, s);
                greed = Math.min(greed, op2);
            }
        }

        return dp[l][r] = Math.min(op1, greed);
    }
    public int strangePrinter(String s) {
        n = s.length();
        dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, n - 1, s.toCharArray());
    }
}