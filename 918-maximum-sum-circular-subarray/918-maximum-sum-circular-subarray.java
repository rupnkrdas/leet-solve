class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int global_max = Integer.MIN_VALUE, global_min = Integer.MAX_VALUE;
        int curr_max = 0, curr_min = 0;

        int total = 0;

        for(int num : nums) {
            total += num;
            curr_max = Math.max(curr_max + num, num);
            curr_min = Math.min(curr_min + num, num);
            global_max = Math.max(global_max, curr_max);
            global_min = Math.min(global_min, curr_min);
        }

        if (global_max > 0) {
            return Math.max(global_max, total - global_min);
        } else {
            return global_max;
        }
    }
}