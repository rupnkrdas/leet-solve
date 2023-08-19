class Solution {
    private long MOD = (long)(1e9 + 7);
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] pow = new long[n + 1];
        pow[0] = 1;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = (pow[i - 1]*2)%MOD;
        }

        long ans = 0;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            if (nums[start] + nums[end] <= target) {
                ans = (ans%MOD + pow[end - start]%MOD)%MOD;
                start++;
            } else {
                end--;
            }
        }

        return (int)(ans);
    }
}