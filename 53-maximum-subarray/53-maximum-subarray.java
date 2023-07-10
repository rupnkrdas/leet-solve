class Solution {
    public int maxSubArray(int[] nums) {
        int global_max = Integer.MIN_VALUE, curr_max = 0;
        for (int num : nums) {
            curr_max = Math.max(curr_max + num, num);
            global_max = Math.max(global_max, curr_max);
        }

        return global_max;
    }
}