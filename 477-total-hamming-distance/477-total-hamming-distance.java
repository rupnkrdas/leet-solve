class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int count_ones      = 0;
            int count_zeroes    = 0;
            
            for (int j = 0; j < n; j++) {
                if ((nums[j] & mask) != 0) count_ones++;
                else count_zeroes++;
            }

            if ((count_ones == n) || (count_zeroes == n)) continue;
            else {
                sum += count_ones * count_zeroes;
            }
        }

        return sum;
    }
}