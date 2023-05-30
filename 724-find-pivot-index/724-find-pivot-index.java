class Solution {
    public int pivotIndex(int[] nums) {
        int tot = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            tot += nums[i];
        }

        int lsum = 0;
        for (int i = 0; i < n; i++) {
            if (lsum == tot - lsum - nums[i]) return i;
            lsum += nums[i];
        }
        

        return -1;
    }
}