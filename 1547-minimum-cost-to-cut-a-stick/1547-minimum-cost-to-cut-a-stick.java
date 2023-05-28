class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] arr = new int[cuts.length + 2];
        arr[0] = 0;
        arr[cuts.length + 2 - 1] = n;
        for (int i = 0; i < cuts.length; i++) {
            arr[i + 1] = cuts[i];
        }

        int c = cuts.length;
        return f(arr, c);
    }

    public int f(int[] arr, int c) {
        int[][] dp = new int[c + 2][c + 2]; // i: 1 --> c, j: 1 --> c
        
        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j) {
                    dp[i][j] = 0;
                    continue;
                }
                int minCost = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = (arr[j + 1] - arr[i - 1]) + dp[i][k - 1]  + dp[k + 1][j];
                    minCost = Math.min(minCost, cost);
                }

                dp[i][j] = minCost;
            }
        }

        return dp[1][c];
    }
}