class Solution {
    int MOD = (int)(1e9+7);
    int endCity;
    int[][] dp = new int[101][201];
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        endCity = finish;
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = f(start, fuel, locations, locations.length);
        return ans % MOD;
    }

    public int f(int city, int fuel, int[] loc, int n) {
        if (fuel < 0) return 0;

        if (dp[city][fuel] != -1) return dp[city][fuel];

        // choices
        // 0 <- n-1, i != city
        long ways = 0;
        if (city == endCity) ways += 1;
        for (int i = 0; i < n; i++) {
            if (i != city) {
                ways += f(i, fuel - Math.abs(loc[i]-loc[city]), loc, n);
            }
        }

        return dp[city][fuel] = (int)(ways % MOD);
    }
}