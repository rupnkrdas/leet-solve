class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    private void solve(int[] nums, int mask, List<Integer> temp, int n) {
        if (temp.size() == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (((1 << i) & mask) == 0) {
                temp.add(nums[i]);
                solve(nums, mask | (1 << i), temp, n);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        solve(nums, 0, new ArrayList<>(), n);

        return ans;
    }
}