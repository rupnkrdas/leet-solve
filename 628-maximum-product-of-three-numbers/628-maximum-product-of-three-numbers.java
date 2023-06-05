class Solution {
    public int maximumProduct(int[] nums) {
        // 2 cases
        // case1 : 3 largest numbers
        // case2 : 2 smallest and 1 largest

        Arrays.sort(nums);
        int n = nums.length;
        return Math.max((nums[0]*nums[1]*nums[n-1]), (nums[n-3]*nums[n-2]*nums[n-1]));
    }
}