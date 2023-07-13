class Solution {
    private int f(int[] nums, int target) {
        int sum = 0;
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum <= target) {
                maxi = i + 1;
            } else {
                break;
            }
        }

        return maxi;
    }
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = f(nums, queries[i]);
        }

        return ans;
    }
}