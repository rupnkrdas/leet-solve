class Solution {
    public int nthUglyNumber(int n) {
        int i2 = 1, i3 = 1, i5 = 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int i2_ugly_number = 2*dp[i2];
            int i3_ugly_number = 3*dp[i3];
            int i5_ugly_number = 5*dp[i5];

            int mini = Math.min(i2_ugly_number, Math.min(i3_ugly_number, i5_ugly_number));
            dp[i] = mini;

            if (mini == i2_ugly_number) {
                i2++;
            }
            if (mini == i3_ugly_number) {
                i3++;
            }
            if (mini == i5_ugly_number) {
                i5++;
            }
        }

        return dp[n];
    }
}