class Solution {
    public int[][] divideArray(int[] nums, int k) {
        // one or more arrays of size = 3
        int n = nums.length;
        if (n%3 != 0) return new int[][]{};

        Arrays.sort(nums);
        int[][] ans = new int[n/3][3];
        int idx = 0;
        for (int i = 0; i < n; i += 3) {
            if (nums[i + 2]-nums[i] > k) return new int[][]{};

            for (int j = i; j < i + 3; j++) {
                ans[idx][j-i] = nums[j];
            }
            idx++;
        }

        return ans;
    }
}