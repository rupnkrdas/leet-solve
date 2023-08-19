class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        char[] arri = str1.toCharArray();
        char[] arrj = str2.toCharArray();
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (arri[i - 1] == arrj[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        String ans = "";
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (arri[i - 1] == arrj[j - 1]) {
                ans = arri[i - 1] + ans;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans = arri[i - 1] + ans;
                i--;
            } else {
                ans = arrj[j - 1] + ans;
                j--;
            }
        }

        while (i > 0) {
            ans = arri[i-- - 1] + ans;
        }
        while (j > 0) {
            ans = arrj[j-- - 1] + ans;
        }

        return ans;
    }
}