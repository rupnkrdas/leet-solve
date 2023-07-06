class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int total_sum = 0;
        for (int num : nums) {
            total_sum += num;
        }
        
        if (total_sum < target) return 0;

        int i = 0, j = 0, sum = 0, n = nums.length, mini = n;

        while (j < n) {
            sum += nums[j];

            if (sum < target) {
                // expand
                j++;
            }
            else { // sum >= target

                while (sum >= target) {
                    mini = Math.min(mini, j - i + 1);
                    sum -= nums[i];
                    i++;
                }

                j++;
            }
        }

        return mini;
    }
}