class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = n - 1;
        Arrays.sort(nums);

        int ops = 0;
        while (i < j) {
            if (nums[i] + nums[j] == k) {
                i++;
                j--;
                ops++;
            } else if (nums[i] + nums[j] < k) {
                i++;
            } else {
                j--;
            }
        }

        return ops;
    }
}