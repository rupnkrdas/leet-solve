class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        return f(prices, n, fee);
    }

    public int f(int[] arr, int n, int fee) {
        // int[][] dp = new int[n + 1][2];
        int[] prev = new int[2];
        for (int index = n; index >= 0; index--) {
            int[] curr = new int[2];

            for (int canBuy = 0; canBuy < 2; canBuy++) {
                if (index == n) {
                    continue;
                }

                if (canBuy == 1) {
                    curr[canBuy] = Math.max(-arr[index] + prev[0],  prev[1]);
                } else {
                    curr[canBuy] = Math.max(arr[index] - fee + prev[1],  prev[0]);
                }
            }

            prev = curr.clone();
        }

        return prev[1];
    }
}