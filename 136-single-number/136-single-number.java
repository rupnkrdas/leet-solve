class Solution {
    public int singleNumber(int[] nums) {
        int zor = 0;
        for (int num : nums) {
            zor ^= num;
        }

        return zor;
    }
}