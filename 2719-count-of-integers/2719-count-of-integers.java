class Solution {
    int MOD = (int)(1e9 + 7);
    int[][][][] dp;
    public int count(String num1, String num2, int min_sum, int max_sum) {
        dp = new int[23][2][2][401];
        for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 401; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }

        String num1extended = "";
        int n1 = num1.length();
        int n2 = num2.length();
        int d = n2 - n1;
        for (int i = 0; i < d; i++) {
            num1extended += '0';
        }

        num1extended += num1;


        int a = countStrings(0, 1, 1, num1extended.toCharArray(), num2.toCharArray(), max_sum);
        int b = countStrings(0, 1, 1, num1extended.toCharArray(), num2.toCharArray(), min_sum - 1);

        int ans = (a - b) % MOD;

        return (ans < 0) ? ans + MOD : ans;
    }

    // here sum denotes "X - digit_sum"
    public int countStrings(int i, int tight1, int tight2, char[] num1, char[] num2, int sum) {
        if (sum < 0)
            return 0; // if sum < 0, not possible
        if (i == num2.length)
            return 1; // if reached end, return 1;

        if (dp[i][tight1][tight2][sum] != -1) {
            return dp[i][tight1][tight2][sum];
        }

        int lo = (tight1 == 1) ? num1[i] - '0' : 0; // if tight1 is tight, then don't start from 0
        int hi = (tight2 == 1) ? num2[i] - '0' : 9; // if tight2 is tight, then don't end at 9

        int count = 0;
        for (int idx = lo; idx <= hi; idx++) {
            count = count % MOD + countStrings(i + 1, ((tight1 == 1) && (idx == lo)) ? 1 : 0, ((tight2 == 1) && (idx == hi)) ? 1 : 0, num1, num2, sum - idx) % MOD;
        }

        return dp[i][tight1][tight2][sum] = count;
    }
}