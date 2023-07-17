class Solution {
    public int maxSubArray(int[] nums) {
        int global_max = Integer.MIN_VALUE;
        int curr_sum = 0;

        for (int num : nums) {
            curr_sum += num;
            global_max = Math.max(global_max, curr_sum);

            if (curr_sum < 0) {
                curr_sum = 0;
            }
        }

        return global_max;
    }
}