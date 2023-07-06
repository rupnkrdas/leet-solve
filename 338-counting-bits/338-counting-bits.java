class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = count_set_bits(i);
        }

        return ans;
    }

    public int count_set_bits(int n) {
        int count = 0;
        while (n != 0) {
            int rsbm = n & -n;
            n -= rsbm;
            count++;
        }

        return count;
    }
}