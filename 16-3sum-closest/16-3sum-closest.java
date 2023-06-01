class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = x + nums[j] + nums[k];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < Math.abs(diff)) {
                    diff = sum - target;
                    ans = sum;
                }

                if (sum > target) {
                    k--;
                }
                if (sum < target) {
                    j++;
                }
            }
        }

        return ans;
    }
}