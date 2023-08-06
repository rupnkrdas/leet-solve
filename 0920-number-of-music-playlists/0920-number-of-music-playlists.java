class Solution {
    int GOAL, N, K;
    private int MOD = (int)(1e9 + 7);
    long[][] dp = new long[101][101];
    private long f(int count, int unique) {
        if (count == GOAL) {
            return (unique == N)?1:0;
        }

        if (dp[count][unique] != -1) return dp[count][unique];
        
        long result = 0;
        //play a unique a song
        if (N - unique >= 0) {
            result = result%MOD + (N - unique) * f(count + 1, unique + 1)%MOD;
        }

        //replay a song
        if (unique - K >= 0) {
            result = result%MOD + (unique - K) * f(count + 1, unique)%MOD;
        }

        return dp[count][unique] = result%MOD;
    }
    public int numMusicPlaylists(int n, int goal, int k) {
        GOAL = goal;
        N = n;
        K = k;

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return (int)(f(0, 0)%MOD);
    }
}