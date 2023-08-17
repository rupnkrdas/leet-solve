class Solution {
    private boolean f(int idx, int[] nums, long sum, long target, int[] mask, int k) {
        if (k == 0) return true;
        if (sum == target) {
            return f(0, nums, 0, target, mask, k - 1);
        }

        boolean ans = false;
        int before = mask[0];
        for (int i = idx; i < nums.length; i++) {
            // if (i > idx && nums[i] == nums[i - 1]) continue;
            if ((mask[0] | (1 << i)) == mask[0]) continue;
            if (sum + nums[i] <= target) {
                mask[0] |= (1 << i);
                if (f(i + 1, nums, sum + nums[i], target, mask, k)) {
                    ans = true;
                    break;
                }
                mask[0] = before;
            }
        }

        return ans;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) return false;
        int[] mask = {0};
        boolean ans = f(0, nums, 0, sum/k, mask, k);
        return ans;
    }
}