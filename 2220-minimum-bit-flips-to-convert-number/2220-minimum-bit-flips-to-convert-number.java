class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            if ((start & mask) != (goal & mask)) count++;
        }

        return count;
    }
}