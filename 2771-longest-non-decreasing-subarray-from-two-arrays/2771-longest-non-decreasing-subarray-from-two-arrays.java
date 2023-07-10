class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n + 1][2]; // dp[i][0] <--- maxNonDecreasingLength ending at index i in nums1
                                                 // dp[i][1] <--- maxNonDecreasingLength ending at index i in nums2

        for (int[] row : dp) {
            Arrays.fill(row, 1); // minimum eligible length
        }

        int best = 1;
        for (int i = 1; i < n; i++) {
            int op1 = 0;
            int op2 = 0;
            if (nums1[i] >= nums1[i - 1]) {
                // dp[i][0] = Math.max(dp[i][0], 1 + dp[i - 1][0]);
                op1 = Math.max(dp[i][0], 1 + dp[i - 1][0]);
            }
            if (nums1[i] >= nums2[i - 1]) {
                // dp[i][0] = Math.max(dp[i][0], 1 + dp[i - 1][1]);
                op2 = Math.max(dp[i][0], 1 + dp[i - 1][1]);
            }
            dp[i][0] = Math.max(dp[i][0], Math.max(op1, op2));

            int op3 = 0;
            int op4 = 0;
            if (nums2[i] >= nums2[i - 1]) {
                // dp[i][1] = Math.max(dp[i][1], 1 + dp[i - 1][1]);
                op3 = Math.max(dp[i][1], 1 + dp[i - 1][1]);
            }
            if (nums2[i] >= nums1[i - 1]) {
                // dp[i][1] = Math.max(dp[i][1], 1 + dp[i - 1][0]);
                op4 = Math.max(dp[i][1], 1 + dp[i - 1][0]);
            }
            dp[i][1] = Math.max(dp[i][1], Math.max(op3, op4));
            

            best = Math.max(best, Math.max(dp[i][0], dp[i][1]));
        }

        return best;
    }
}