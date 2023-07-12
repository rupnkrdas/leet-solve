class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] % 2 == 0) ? nums[i] : 0;
        }

        int[] ans = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
            int val     = q[0];
            int index   = q[1];

            if (nums[index] % 2 == 0) {
                if (val % 2 == 0) {
                    sum -= nums[index];
                    nums[index] += val;
                    sum += nums[index];
                } else {
                    sum -= nums[index];
                    nums[index] += val;
                }
            } else {
                if (val % 2 != 0) {
                    nums[index] += val;
                    sum += nums[index];
                } else {
                    nums[index] += val;
                }
            }

            ans[i++] = sum;
        }

        return ans;
    }
}