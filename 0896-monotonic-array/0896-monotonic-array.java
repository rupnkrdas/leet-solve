class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        int prev = nums[0];

        if (nums[n - 1] >= nums[0]) {
            // check asc
            for (int i = 1; i < n; i++) {
                if (nums[i] >= nums[i - 1]) {
                    prev = nums[i];
                } else {
                    return false;
                }
            }
        } else {
            // check desc
            prev = nums[0];
            for (int i = 1; i < n; i++) {
                if (nums[i] <= nums[i - 1]) {
                    prev = nums[i];
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}