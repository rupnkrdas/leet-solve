class Solution {
    public int[][] divideArray(int[] nums, int k) {
        // one or more arrays of size = 3
        int n = nums.length;
        if (n%3 != 0) return new int[][]{};

        Arrays.sort(nums);
        int[][] ans = new int[n/3][3];
        int ans_idx = 0;
        for (int i = 0; i < n; i += 3) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < i + 3; j++) {
                list.add(nums[j]);
            }

            if (list.get(2)-list.get(0) > k) return new int[][]{};
            for (int idx = 0; idx < 3; idx++) {
                ans[ans_idx][idx] = list.get(idx);
            }
            ans_idx++;
        }

        return ans;
    }
}