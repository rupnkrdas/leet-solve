class Solution {
    int MOD = (int)(1e9 + 7);
    int[] dp = new int[(int)(1e5 + 1)];
    public int numberOfArrays(String s, int k) {
        Arrays.fill(dp, -1);
        return (int)(f(0, s, k)) % MOD;
    }

    public int f(int start, String s, int k) {
        if (start >= s.length()) return 1;
        if (s.charAt(start) == '0') return 0;

        if (dp[start] != -1) return dp[start];

        long total_ways = 0;
        long num = 0;
        for (int end = start; end < s.length(); end++) {
            num = num*10 + (long)(s.charAt(end) - '0');
            if (num <= k) {
                total_ways = total_ways % MOD + f(end + 1, s, k) % MOD;
            } else {
                break;
            }
        }

        return dp[start] = (int)(total_ways % MOD);
    }
}