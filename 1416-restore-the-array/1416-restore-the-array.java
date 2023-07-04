class Solution {
    int MOD = (int)(1e9 + 7);
    int[] dp = new int[(int)(1e5 + 1)];
    public int numberOfArrays(String s, int k) {
        Arrays.fill(dp, -1);
        return (int)(f(0, s, k)) % MOD;
    }

    public int f(int idx, String s, int k) {
        if (idx >= s.length()) return 1;

        if (dp[idx] != -1) return dp[idx];

        long total_ways = 0;
        for (int i = idx + 1; i <= s.length(); i++) {
            String s_ = s.substring(idx, i);
            if (s_.charAt(0) != '0' && Long.parseLong(s_) <= (long)k) {
                total_ways = total_ways % MOD + f(i, s, k) % MOD;
            } else {
                break;
            }
        }

        return dp[idx] = (int)(total_ways % MOD);
    }
}