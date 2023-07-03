class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) return new int[]{start + 1, end + 1};
            if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return new int[] {-1,-1};
    }
}