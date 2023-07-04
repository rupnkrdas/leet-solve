class Solution {
    private int MOD = (int)(1e9 + 7);
    int[] dp = new int[(int)(2e5 + 1)];
    public int countGoodStrings(int low, int high, int zero, int one) {
        Arrays.fill(dp, -1);
        return f(0, zero, one, low, high) % MOD;
    }

    public int f(int size, int zero, int one, int low, int high) {
        if (size == high) return 1;
        if (size > high) return 0;

        if (dp[size] != -1) return dp[size];

        int ans = 0;
        if (size >= low) {
            ans += 1;
        }
        // take-zero
        ans = ans % MOD + f(size + zero, zero, one, low, high) % MOD;
        // take-one
        ans = ans % MOD + f(size + one, zero, one, low, high) % MOD;

        return dp[size] = ans % MOD;
    }
}