class Solution {
    int[][][] dp;
    public int stoneGameII(int[] piles) {
        dp = new int[101][2][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 101; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve_for_Alice(0, piles, 1, 1);
    }

    public int solve_for_Alice(int idx, int[] piles, int alice_turn, int M) {
        if (idx == piles.length) return 0;
        
        if (dp[idx][alice_turn][M] != -1) return dp[idx][alice_turn][M];

        int stones = 0;
        int res = (alice_turn == 1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        
        for (int x = 1; x <= Math.min(2*M, piles.length - idx); x++) {
            stones += piles[idx + x - 1];
            
            if (alice_turn == 1) { // alice's turn
                res = Math.max(res, stones + solve_for_Alice(idx + x, piles, 0, Math.max(M, x)));
            } else { // bob's turn
                res = Math.min(res, solve_for_Alice(idx + x, piles, 1, Math.max(M, x)));
            }
        }

        return dp[idx][alice_turn][M] = res;
    }
}