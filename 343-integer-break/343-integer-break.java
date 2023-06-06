class Solution {
    int[] dp = new int[59];
    int num;
    public int integerBreak(int n) {
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        num = n;
        return f(n);
    }

    public int f(int n) {
        if (n == 1) return 1;

        if (dp[n] != -1) return dp[n];

        int prod = (n == num) ? 0 : n;
        for (int i = 1; i < n; i++) {
            int val = f(i) * f(n - i);
            prod = Math.max(prod, val);
        }

        return dp[n] = prod;
    }
    
}