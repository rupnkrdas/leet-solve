class Solution {
    long[][] dp;
    private long f(int idx, int isEven, int[] nums) {
        if (idx == nums.length) return 0;

        if (dp[idx][isEven] != -1) return dp[idx][isEven];

        // take
        long take = (isEven == 1) ? nums[idx] + f(idx + 1, 0, nums) : -nums[idx] + f(idx + 1, 1, nums);

        // not-take
        long not_take = 0 + f(idx + 1, isEven, nums);

        return dp[idx][isEven] = Math.max(take, not_take);
    }
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        dp = new long[n + 1][2];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f(0, 1, nums);
    }
}