class Solution {
    public int maxSubArray(int[] nums) {
        int global_max = Integer.MIN_VALUE;
        int curr_max = 0;

        for (int num : nums) {
            curr_max += num;
            
            if (curr_max > global_max) {
                global_max = curr_max;
            }
            if (curr_max < 0) { // if curr_max drops to negative, reset it to 0
                                // this is the typical Kadane's Algorithm
                curr_max = 0;
            }
        }

        return global_max;
    }
}