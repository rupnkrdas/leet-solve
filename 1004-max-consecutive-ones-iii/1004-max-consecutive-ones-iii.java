class Solution {
    public int longestOnes(int[] nums, int k) {
        int[] freq = new int[2];
        int n = nums.length;

        
        int i = 0, j = 0;
        int maxi = 0;
        while (j < n) {
            freq[nums[j]]++;

            if (freq[0] <= k) {
                maxi = Math.max(maxi, j - i + 1);
            } else {
                freq[nums[i]]--;
                i++;
            }

            j++;
        }

        return maxi;
    }
}