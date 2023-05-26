class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        return f(piles, n) > 0 ? true : false;
    } 
    
    public int f(int[] p, int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                if (i == j) {
                    dp[i][j] = p[i];
                    continue;
                }
                
                int ans = Integer.MIN_VALUE;
        
                // take from first
                int op1 = p[i] - dp[i + 1][j];
                // take from last
                int op2 = p[j] - dp[i][j - 1];

                ans = Math.max(ans, Math.max(op1, op2));

                dp[i][j] = ans;
            }
        }
        
        return dp[0][n - 1];
    }
}