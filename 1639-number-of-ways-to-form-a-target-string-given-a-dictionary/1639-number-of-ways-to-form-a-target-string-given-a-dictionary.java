class Solution {
    int[][] freq;
    long[][] dp = new long[1001][1001];
    private long MOD = (long)(1e9 + 7);
    public int numWays(String[] words, String target) {
        int n = words.length;
        int m = words[0].length();
        freq = new int[26][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = words[i].charAt(j);
                freq[c-'a'][j]++;
            }
        }

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return (int)(f(0, 0, target, m)%MOD);
    }
    private long f(int i, int j, String target, int wordLength) {
        if (i == target.length()) return 1;
        if (j == wordLength) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        long not_take = f(i, j + 1, target, wordLength)%MOD;
        char c = target.charAt(i);
        long take = f(i + 1, j + 1, target, wordLength)%MOD*freq[c-'a'][j]%MOD;

        return dp[i][j] = (take + not_take)%MOD;
    }
}