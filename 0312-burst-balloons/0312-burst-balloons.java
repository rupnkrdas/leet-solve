class Solution {
    int[][] dp = new int[303][303];
    private int f(int i, int j, List<Integer> list) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int maxi = Integer.MIN_VALUE;
        for (int idx = i; idx <= j; idx++) {
            int op = list.get(i - 1)*list.get(idx)*list.get(j+1) + f(i, idx - 1, list) + f(idx + 1, j, list);
            maxi = Math.max(maxi, op);
        }

        dp[i][j] = maxi;
        return maxi;
    }
    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int num : nums) {
            list.add(num);
        }
        list.add(1);

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int n = list.size();
        return f(1, n - 2, list);
    }
}