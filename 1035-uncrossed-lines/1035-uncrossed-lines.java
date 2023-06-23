class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return f(nums1, nums2);
    }

    public int f(int[] nums1, int[] nums2) {
        int[][] dp = new int[501][501];
        for (int i = nums1.length; i >= 0; i--) {
            for (int j = nums2.length; j >= 0; j--) {
                if (i == nums1.length || j == nums2.length) continue;
                
                int take = 0;
                if (nums1[i] == nums2[j]) {
                    take = 1 + dp[i + 1][j + 1];
                }

                int notTake1 = 0 + dp[i + 1][j];
                int notTake2 = 0 + dp[i][j + 1]; 

                dp[i][j] = Math.max(take, Math.max(notTake1, notTake2));
            }
        }

        return dp[0][0];
    }
}