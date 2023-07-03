class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        
        Arrays.sort(nums);
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            maxi = Math.max(maxi, nums[i + 1] - nums[i]);
        }

        return maxi;
    }
}