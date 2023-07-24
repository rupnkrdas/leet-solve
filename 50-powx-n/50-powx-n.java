class Solution {
    public double myPow(double x, int n) {
        double res = f(x, Math.abs(n));
        return (n < 0) ? 1/res : res;
    }

    private double f(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;

        double res = f(x*x, n / 2);
        res *= (n%2 != 0) ? x : 1;

        return res;
    }
}