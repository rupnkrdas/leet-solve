class Solution {
    public long minimumReplacement(int[] nums) {
        long count = 0;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                int parts = (int)Math.ceil(1.0*nums[i]/nums[i + 1]);
                count += parts-1;
                nums[i] /= parts;
            }
        }

        return count;
    }
}