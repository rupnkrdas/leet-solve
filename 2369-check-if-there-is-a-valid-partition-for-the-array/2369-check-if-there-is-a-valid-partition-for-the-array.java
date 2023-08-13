class Solution {
    int[] dp = new int[(int)(1e5 + 1)];
    private boolean f(int idx, int[] nums) {
        if (idx == nums.length) return true;

        if (dp[idx] != -1) {
            return (dp[idx]==1)?true:false;
        }
        
        boolean ans = false;
        int n = nums.length;
        if (idx + 1 < n && nums[idx] == nums[idx + 1]) {
            if (f(idx+2, nums)) {
                ans = true;
            }
        }
        if (!ans && idx + 2 < n && nums[idx] == nums[idx + 1] && nums[idx + 1] == nums[idx + 2]) {
            if (f(idx + 3, nums)) {
                ans = true;
            }
        }
        if (!ans && idx + 2 < n && nums[idx] + 1 == nums[idx + 1] && nums[idx + 1] + 1 == nums[idx + 2]) {
            if (f(idx + 3, nums)) {
                ans = true;
            }
        }

        dp[idx] = ans?1:0;
        return ans;
    }
    public boolean validPartition(int[] nums) {
        Arrays.fill(dp, -1);
        return f(0, nums);
    }
}