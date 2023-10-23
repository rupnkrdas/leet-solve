class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;
        return (double)Math.floor((double)(Math.log(n))/Math.log(4)) == (double)(Math.log(n)/Math.log(4));
    }
}