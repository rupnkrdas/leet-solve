class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxi = 0;
        for (int i = 0; i < n/2; i++) {
            int sum = nums[i] + nums[n - 1 - i];
            maxi = Math.max(maxi, sum);
        }

        return maxi;
    }
}