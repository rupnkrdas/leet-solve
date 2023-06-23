class Solution {
    int[][] dp = new int[501][501];
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        for (int i = 0; i < 501; i++) {
            for (int j = 0; j < 501; j++) {
                dp[i][j] = -1;
            }
        }
        return f(0, 0, nums1, nums2);
    }

    public int f(int i, int j, int[] nums1, int[] nums2) {
        if (i == nums1.length || j == nums2.length) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int take = 0;
        if (nums1[i] == nums2[j]) {
            take = 1 + f(i + 1, j + 1, nums1, nums2);
        }

        int notTake1 = 0 + f(i + 1, j, nums1, nums2);
        int notTake2 = 0 + f(i, j + 1, nums1, nums2);

        return dp[i][j] = Math.max(take, Math.max(notTake1, notTake2));
    }
}