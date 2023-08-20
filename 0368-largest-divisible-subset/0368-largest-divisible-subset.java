class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] parent = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int lastIndex = 0;
        int maxi = 1;
        for (int index = 0; index < n; index++) {
            parent[index] = index;
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {
                if (nums[index] % nums[prevIndex] == 0 && dp[prevIndex] + 1 > dp[index]) {
                    dp[index] = dp[prevIndex] + 1;
                    parent[index] = prevIndex;
                }
            }

            if (dp[index] > maxi) {
                maxi = dp[index];
                lastIndex = index;
            }
        }

        List<Integer> list = new ArrayList<>();
        int node = lastIndex;
        while (parent[node] != node) {
            list.add(nums[node]);
            node = parent[node];
        }
        list.add(nums[node]);

        Collections.reverse(list);
        return list;
    }
}