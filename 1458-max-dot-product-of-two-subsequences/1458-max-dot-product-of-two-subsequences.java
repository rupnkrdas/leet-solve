class Solution {
    int[][][] dp = new int[501][501][2];
    private int f(int idx, int j, int taken, int[] nums1, int[] nums2) {
        if (idx == nums1.length) {
            if (taken == 0) return Integer.MIN_VALUE;
            else return 0;
        }

        if (dp[idx][j][taken] != -1) return dp[idx][j][taken];

        // take-idx
        // find its couterpart in nums2
        int take = Integer.MIN_VALUE;
        for (int i = j; i < nums2.length; i++) {

            take = Math.max(take, nums1[idx]*nums2[i] + f(idx + 1, i + 1, 1, nums1, nums2));
        }

        // not take
        int notTake = f(idx + 1, j, taken, nums1, nums2);

        return dp[idx][j][taken] = Math.max(take, notTake);
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        // 2 1 -2 5
        // 3 0 -6
        // same length

        for (int i = 0; i < 501; i++) {
            for (int j = 0; j < 501; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return f(0, 0, 0, nums1, nums2);
    }
}