class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public long minCost(int[] nums, int[] cost) {
        long ans = Long.MAX_VALUE;

        int n = nums.length;
        Pair pair = find(nums);
        int start = pair.first;
        int end = pair.second;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            long cost1 = findCost(nums, cost, mid);
            long cost2 = findCost(nums, cost, mid + 1);

            ans = Math.min(cost1, cost2);

            if (cost2 > cost1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public Pair find(int[] nums) {
        int mini = nums[0];
        int maxi = nums[0];

        for (int i = 1; i < nums.length; i++) {
            mini = Math.min(mini, nums[i]);
            maxi = Math.max(maxi, nums[i]);
        }

        return new Pair(mini, maxi);
    }

    public long findCost(int[] nums, int[] cost, int target) {
        long totCost = 0;
        for (int i = 0; i < nums.length; i++) {
            totCost += (Math.abs(target - nums[i])) * (long)cost[i];
        }

        return totCost;
    }
}