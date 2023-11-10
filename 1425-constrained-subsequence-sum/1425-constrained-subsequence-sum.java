class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int N = nums.length;
        int[] dp = new int[N]; // dp[i] : stores the max sub sum till index i
        for (int i = 0; i < N; i++) {
            dp[i] = nums[i];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int maxi = Integer.MIN_VALUE;
        for (int index = 0; index < N; index++) {
            while (!pq.isEmpty() && index - pq.peek()[1] > k) pq.poll();
            int top = (!pq.isEmpty()) ? pq.peek()[0] : 0;
            dp[index] = Math.max(dp[index], top + nums[index]);

            pq.offer(new int[]{dp[index], index});
            maxi = Math.max(maxi, dp[index]);
        }

        // System.out.println(Arrays.toString(dp));
        return maxi;
    }
}