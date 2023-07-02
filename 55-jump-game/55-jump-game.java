class Solution {
    int[] dp = new int[(int)(1e4 + 1)];
    public boolean canJump(int[] nums) {
        Arrays.fill(dp, -1);
        return (f(0, nums) == 1);
    }

    public int f(int idx, int[] nums) {
        if (idx == nums.length - 1) return 1;

        if (dp[idx] != -1) return dp[idx];

        for (int i = 1; i <= nums[idx]; i++) {
            if (f(idx + i, nums) == 1) return dp[idx] = 1;
        }

        return dp[idx] = 0;
    }
}