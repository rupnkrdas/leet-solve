class Solution {
    public int trailingZeroes(int n) {
        if (n == 0) return 0;

        int count5 = 0;
        while (n != 0) {
            count5 += n/5;
            n /= 5;
        }

        return count5;
    }
}