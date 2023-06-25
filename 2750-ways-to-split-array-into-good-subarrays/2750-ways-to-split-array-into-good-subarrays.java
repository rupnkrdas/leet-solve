class Solution {
    int[][] dp;
    int MOD = (int)(1e9 + 7);

    public int f(int i, int found1, int[] nums) {
        if (i >= nums.length) {
            return (found1 == 1) ? 1 : 0;
        }

        if (dp[i][found1] != -1) return dp[i][found1];

        long ans = 0;  // Use long to prevent integer overflow

        if (nums[i] == 0) {
            if (found1 == 1) {
                // split
                long a = f(i + 1, 0, nums);

                // dont split
                long b = f(i + 1, 1, nums);

                ans = a + b;
            } else {
                // continue looking
                // cannot split
                ans = f(i + 1, 0, nums);
            }
        } else { // nums[i] == 1
            // found 1
            // have to split, no other option
            ans = f(i + 1, 1, nums);
        }

        return dp[i][found1] = (int)(ans % MOD);
    }

    public int numberOfGoodSubarraySplits(int[] nums) {
        dp = new int[nums.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(0, 0, nums);
    }
}
