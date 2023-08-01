class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    private void solve(int idx, int[] nums, int k, List<Integer> temp) {
        if (idx == nums.length) {
            if (temp.size() == k) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        temp.add(nums[idx]);
        solve(idx + 1, nums, k, temp);
        temp.remove(temp.size() - 1);
        solve(idx + 1, nums, k, temp);
    }
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        solve(0, nums, k, new ArrayList<>());

        return ans;
    }
}