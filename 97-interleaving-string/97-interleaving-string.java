class Solution {
    Map<String, Boolean> map = new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return f(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), s1.length(), s2.length(), s3.length());
    }

    public boolean f(char[] s1, char[] s2, char[] s3, int len1, int len2, int len3) {
        boolean[][][] dp = new boolean[101][101][201];
        for (int p1 = len1; p1 >= 0; p1--) {
            for (int p2 = len2; p2 >= 0; p2--) {
                for (int p3 = len3; p3 >= 0; p3--) {
                    if (p3 == len3) {
                        if (p1 == len1 && p2 == len2) dp[p1][p2][p3] = true;
                        else {
                            dp[p1][p2][p3] = false;
                        }
                        continue; 
                    }

                    boolean op1 = false;
                    boolean op2 = false;
                    if (p3 < len3 && p1 < len1 && s3[p3] == s1[p1]) {
                        op1 = dp[p1 + 1][p2][p3 + 1];
                    }
                    if (p3 < len3 && p2 < len2 && s3[p3] == s2[p2]) {
                        op2 = dp[p1][p2 + 1][p3 + 1];
                    }

                    dp[p1][p2][p3] = op1 || op2;
                }
            }
        }

        return dp[0][0][0];
    }
}