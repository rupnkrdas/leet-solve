class Solution {
    public int majorityElement(int[] nums) {
        int ans = -1;
        int count = 0;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (count == 0) ans = nums[i];
            if (nums[i] == ans) count++;
            else count--;
        }

        return ans;
    }
}