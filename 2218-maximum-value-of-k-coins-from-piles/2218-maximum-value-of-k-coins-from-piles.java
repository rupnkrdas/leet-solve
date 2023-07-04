class Solution {
    int[][] dp = new int[1001][2001];
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(0, piles, k);
    }

    public int f(int idx, List<List<Integer>> piles, int k) {
        if (idx == piles.size()) return 0;
        if (k == 0) return 0;

        if (dp[idx][k] != -1) return dp[idx][k];

        // not-take
        int notTake = f(idx + 1, piles, k);

        // take
        int take = 0;
        int sum = 0;
        for (int i = 0; i < Math.min(piles.get(idx).size(), k); i++) {
            sum += piles.get(idx).get(i);
            take = Math.max(sum + f(idx + 1, piles, k - (i + 1)), take);
        }

        return dp[idx][k] = Math.max(take, notTake);
    }
}