class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int rsbm = n & (-n);
        return ((n^rsbm) == 0);
    }
}