class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long total_sum = 0;
        for (int num : nums) {
            total_sum += num;
        }

        long mini = Long.MAX_VALUE;
        long presum = 0;
        int min_index = 0;
        for (int i = 0; i < n; i++) {
            presum += nums[i];
            long right_sum = total_sum - presum;
            long nums_left = i + 1;
            long nums_right = n - nums_left;

            long left = presum/nums_left;
            long right = 0;
            if (nums_right > 0) {
                right = right_sum/nums_right;
            }

            long avg_diff = Math.abs(left - right);
            if (avg_diff < mini) {
                mini = avg_diff;
                min_index = i;
            }
        }

        return min_index;
    }
}