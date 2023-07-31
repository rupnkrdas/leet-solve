class Solution {
    int[][] dp = new int[1001][1001];
    private int f(int i, int j, char[] s1, char[] s2) {
        // base-case
        if (i == s1.length || j == s2.length) {
            if (i == s1.length && j == s2.length) return 0;
            if (i == s1.length && j != s2.length) {
                int sum = 0;
                for (int k = j; k < s2.length; k++) {
                    sum += (int)s2[k];
                }

                return sum;
            } else {
                int sum = 0;
                for (int k = i; k < s1.length; k++) {
                    sum += (int)s1[k];
                }

                return sum;
            }
        }

        if (dp[i][j] != -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;
        if (s1[i] == s2[j]) {
            mini = Math.min(mini, f(i + 1, j + 1, s1, s2));
        } else {
            mini = Math.min(mini, (int)s1[i] + f(i + 1, j, s1, s2));
            mini = Math.min(mini, (int)s2[j] + f(i, j + 1, s1, s2));
            mini = Math.min(mini, (int)s1[i] + (int)s2[j] + f(i + 1, j + 1, s1, s2));
        }

        return dp[i][j] = mini;
    }
    public int minimumDeleteSum(String s1, String s2) {
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f(0, 0, s1.toCharArray(), s2.toCharArray());
    }
}