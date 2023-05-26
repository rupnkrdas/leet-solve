class Solution {
    int[][] dp;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return f(0, n - 1, piles) > 0 ? true : false;
    } 
    
    public int f(int i, int j, int[] p) {
        if (i == j) {
            return p[i];
        }
        
        if (dp[i][j] != -1) return dp[i][j];
        
        int ans = Integer.MIN_VALUE;
        
        // take from first
        int op1 = p[i] - f(i + 1, j, p);
        // take from last
        int op2 = p[j] - f(i, j - 1, p);
        
        ans = Math.max(ans, Math.max(op1, op2));
        
        return dp[i][j] = ans;
    }
}