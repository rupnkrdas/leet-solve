class Solution {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        int[] nums2 = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nums2[i] = nums[i % n];
        }

        long minCost = Long.MAX_VALUE;

        long[] costs = new long[n]; // stores the min cost for each of the chocolates
        Arrays.fill(costs, Long.MAX_VALUE);

        for(int rotation = 0; rotation < n; rotation++) {
            long totalCost = 0;
            for (int j = 0; j < n; j++) {
                costs[j] = Math.min(costs[j], nums2[j + rotation]);
                totalCost += costs[j];
            }
            totalCost += (long)x * (long)rotation;
            minCost = Math.min(minCost, totalCost);
        }

        return minCost;
    }
}