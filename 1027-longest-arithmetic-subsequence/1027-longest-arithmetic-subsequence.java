class Solution {
    public int longestArithSeqLength(int[] arr) {
        int n = arr.length;
        if (n <= 2)
            return n;

        Map<Integer, Integer> map = new HashMap<>(); // (nums[i], i)
        int[][] dp = new int[1001][1001];
        int ans = 1;

        // Iterate over the array
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = arr[j] - arr[i];
                int need = arr[i] - diff;

                // Check if there is a previous element (need) in the map that forms an arithmetic subsequence with the current pair (i, j).
                if (map.containsKey(need)) {
                    // If a previous element exists, update the length of the arithmetic subsequence ending at (i, j).
                    dp[i][j] = Math.max(dp[map.get(need)][i] + 1, dp[i][j]);
                } else {
                    // If a previous element doesn't exist, initialize the length of the arithmetic subsequence ending at (i, j) to 2.
                    dp[i][j] = 2;
                }

                // Update the maximum length of the arithmetic subsequence encountered so far.
                ans = Math.max(ans, dp[i][j]);
            }
            
            // Store the current element and its index in the map.
            map.put(arr[i], i);
        }

        return ans;
    }
}