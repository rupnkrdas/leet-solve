class Solution {
    Map<String, Boolean> dp = new HashMap<>();
    private boolean f(List<Integer> nums, int start, int end, int m, int sum) {
        if (start == end) return true;
        if (sum < m) return false;

        String key = Integer.toString(start) + "," + Integer.toString(end) + "," + Integer.toString(sum);
        if (dp.containsKey(key)) return dp.get(key);


        boolean left_1 = f(nums, start + 1, end, m, sum - nums.get(start));
        boolean right_1 = f(nums, start, end - 1, m, sum - nums.get(end));

        boolean ans = left_1 || right_1;
        dp.put(key, ans);

        return ans;
    }
    public boolean canSplitArray(List<Integer> nums, int m) {
        int total_sum = 0;
        int n = nums.size();
        if (n <= 2) return true;
        for (int num : nums) {
            total_sum += num;
        }

        return f(nums, 0, n - 1, m, total_sum);
    }
}