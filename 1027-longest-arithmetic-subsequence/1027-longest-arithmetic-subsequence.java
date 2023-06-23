class Solution {
    public int longestArithSeqLength(int[] nums) {
        int[][] dp = new int[1001][1002]; // dp[index][difference]
        int maxi = 2;

        int n = nums.length;
        for (int index = 1; index < n; index++) {
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {
                int diff = nums[index] - nums[prevIndex] + 501;
                dp[index][diff] = (dp[prevIndex][diff] > 0) ? (1 + dp[prevIndex][diff]) : 2;
                maxi = Math.max(maxi, dp[index][diff]);
            }
        }

        return maxi;
    }
}