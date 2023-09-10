class Solution {
    private int MOD = (int)(1e9 + 7);
    int[][] ncr;
    private int f(int n, int r) {
        return ncr[n][r];
    }
    private void fill(int n) {
        ncr = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            ncr[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                ncr[i][j] = ncr[i - 1][j] + ncr[i - 1][j - 1];
            }
        }
    }
    public int countOrders(int n) {
        fill(2*n);
        long ans = 1;
        int total = 2*n;
        while (total > 2) {
            ans = ans%MOD * f(total, 2)%MOD;
            total -= 2;
        }

        return (int)(ans%MOD);
    }
}