class Solution {
    public int longestSubarray(int[] nums) {
        int[] freq = new int[2];


        int i = 0;
        int j = 0;
        int n = nums.length;
        int maxi = 0;
        while (j < n) {
            int num = nums[j];
            freq[num]++;

            if(freq[1] >= (j - i)) {
                maxi = Math.max(maxi, freq[1]);
            }
            else {
                while(freq[1] < (j - i)) {
                    freq[nums[i]]--;
                    i++;
                }
            }

            j++;
        }

        return (maxi != nums.length) ? maxi : maxi - 1;
    }
}