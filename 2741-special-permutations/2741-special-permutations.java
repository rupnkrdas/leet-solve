class Solution {
    int[][] dp;
    int MOD = (int)(1e9 + 7); 
    public int specialPerm(int[] nums) {
        int n = nums.length;
        
        dp = new int[n + 1][1 << 14];
        for(int i = 0; i < n+1; i++) {
            for (int j = 0; j < 1 << 14; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(-1, 0, 0, nums) % MOD;
    }

    public int solve(int prevIndex, int currentIndex, int mask, int[] nums) {
        // base-cases
        if (currentIndex == nums.length) return 1;

        if (dp[prevIndex + 1][mask] != -1) return dp[prevIndex + 1][mask] % MOD;

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((1 << i & mask) == 0) {
                if (prevIndex == -1 || nums[prevIndex] % nums[i] == 0 || nums[i] % nums[prevIndex] == 0) {
                    ans = ans % MOD + solve(i, currentIndex + 1, mask | (1 << i), nums) % MOD;
                }
            }
        }

        return dp[prevIndex + 1][mask] = ans % MOD;
    }
}