class Solution {
    int[] dp;
    private int f(int target, int[] nums) {
        if (target == 0) {
            return 1;
        }

        if (dp[target] != -1) {
            return dp[target];
        }

        int take = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                take += f(target - nums[i], nums);
            }
        }

        return dp[target] = take;
    }
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return f(target, nums);
    }
}