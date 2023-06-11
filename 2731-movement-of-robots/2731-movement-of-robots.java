class Solution {
    int MOD = (int)(1e9 + 7);
    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') nums[i] += d;
            else nums[i] -= d;
        }
        
        Arrays.sort(nums);
        long ans = 0;
        long prefixSum = 0;
        for (int i = 0; i < n; i++) {
            ans += (long)i*(long)nums[i] - prefixSum;
            ans %= MOD;
            prefixSum += (long)nums[i];
        }
        
        return (int)(ans % MOD);
    }
}