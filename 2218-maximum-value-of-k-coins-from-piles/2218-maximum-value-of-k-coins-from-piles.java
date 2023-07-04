class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        return f(piles, k);
    }

    public int f(List<List<Integer>> piles, int K) {
        int[][] dp = new int[1001][2001];
        for(int idx = piles.size(); idx >= 0; idx--) {
            for (int k = K; k >= 0; k--) {
                if (idx == piles.size()) {
                    dp[idx][k] = 0;
                    continue;
                }
                if (k == 0) {
                    dp[idx][k] = 0;
                    continue;
                }

                // not-take
                int notTake = dp[idx + 1][k];

                // take
                int take = 0;
                int sum = 0;
                for (int i = 0; i < Math.min(piles.get(idx).size(), k); i++) {
                    sum += piles.get(idx).get(i);
                    take = Math.max(sum + dp[idx + 1][k - (i + 1)], take);
                }

                dp[idx][k] = Math.max(take, notTake);
            }
        }

        return dp[0][K];
    }
}