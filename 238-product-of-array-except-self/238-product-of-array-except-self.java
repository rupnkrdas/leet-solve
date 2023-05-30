class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] lp = new int[n];
        int[] rp = new int[n];

        lp[0] = 1;
        rp[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            lp[i] = lp[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            rp[i] = rp[i + 1] * nums[i + 1];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = lp[i] * rp[i];
        }

        return ans;
    }
}