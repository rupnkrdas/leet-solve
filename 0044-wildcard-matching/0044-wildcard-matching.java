class Solution {
    private boolean f(int i, int j, char[] arri, char[] arrj, int[][] dp) {
        if (i == arri.length) return (j == arrj.length);
        if (j == arrj.length) {
            while (i < arri.length) {
                if (arri[i++] != '*') return false;
            }

            return true;
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 1 ? true : false;
        }

        boolean ans = false;

        if (arri[i] == arrj[j]) {
            ans = f(i + 1, j + 1, arri, arrj, dp);
        } else {
            if (arri[i] == '?') ans = f(i + 1, j + 1, arri, arrj, dp);
            else if (arri[i] == '*') {
                ans = f(i, j + 1, arri, arrj, dp) || f(i + 1, j, arri, arrj, dp);
            } else {
                return false;
            }
        }

        dp[i][j] = ans?1:0;
        return ans;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f(0, 0, p.toCharArray(), s.toCharArray(), dp);
    }
}