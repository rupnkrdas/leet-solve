class Solution {
    double[][] dp;
    int[] serveA = {100, 75, 50, 25};
    int[] serveB = {0, 25, 50, 75};

    private double solve(int A, int B) {
        if (A <= 0 && B <= 0) return 0.5;
        if (A <= 0) return 1.0;
        if (B <= 0) return 0.0;

        if (dp[A][B] != -1) return dp[A][B];
        
        double p = 0;
        for (int i = 0; i < 4; i++) {
            p += solve(A - serveA[i], B - serveB[i]);
        }

        return dp[A][B] = 0.25*p;
    }

    public double soupServings(int n) {
        if (n >= 4000) return 1;
        dp = new double[n + 1][n + 1];
        for (double[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(n, n);    
    }
}