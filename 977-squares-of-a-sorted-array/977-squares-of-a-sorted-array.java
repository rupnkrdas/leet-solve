class Solution {
    public int[] sortedSquares(int[] nums) {
        // two pointers approach
        int n = nums.length;
        int i = 0;
        int j = n - 1;

        int[] ans = new int[n];
        int k = n - 1;
        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                ans[k] = nums[i] * nums[i];  
                i++;
            } else {
                ans[k] = nums[j] * nums[j];
                j--;
            }
            k--;
        }

        return ans;
    }
}