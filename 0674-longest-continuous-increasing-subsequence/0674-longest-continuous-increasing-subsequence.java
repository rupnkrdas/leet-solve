class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int len = 1;
        int maxi = 1;
        int prev = nums[0];

        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= prev) {
                len = 1;
            } else {
                len++;
            }

            prev = nums[i];
            maxi = Math.max(maxi, len);
        }

        return maxi;
    }
}