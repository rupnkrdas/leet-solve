class Solution {
    int[][] dp;
    public int minFlipsMonoIncr(String s) {
        dp = new int[s.length() + 1][2];
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        return f(0, 0, s.toCharArray());
    }

    public int f(int index, int prev, char[] s) {
        if (index == s.length) {
            return 0;
        }

        if (dp[index][prev] != -1) return dp[index][prev];

        char c = s[index];
        int flip = (int)(1e9);
        int skip = (int)(1e9);
        if(prev == 1) { // prev = 1
            if (c == '1') { // curr = 1
                skip = f(index + 1, 1, s);
            } else { // curr = 0
                flip = 1 + f(index + 1, 1, s);
            }
        } else { // prev = 0
            if (c == '0') { // curr = 0
                skip = f(index + 1, 0, s);
            } else { // curr = 1
                flip = 1 + f(index + 1, 0, s);
                skip = f(index + 1, 1, s);
            }
        }

        return dp[index][prev] = Math.min(skip, flip);
    }
}