class Solution {
    double[][][] dp;
    int[][] dir = { 
        {-2, -1}, {-2, +1},
        {-1, -2}, {-1, +2},
        {+1, -2}, {+1, +2},
        {+2, -1}, {+2, +1},
    };

    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }

    private double f(int i, int j, int k, int n) {
        if (k == 0) {
            if (isSafe(i, j, n, n)) return 1;
            return 0;
        }

        // pruning
        if (!isSafe(i, j, n, n)) return 0;

        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }

        double total = 0; // total ways
        for (int[] d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];

            total += f(ni, nj, k - 1, n);
        }

        return dp[i][j][k] = total/8.0; // probability = total_ways / 8
    }
    public double knightProbability(int n, int K, int row, int column) {
        dp = new double[n][n][K + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < K + 1; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return f(row, column, K, n);
    }
}