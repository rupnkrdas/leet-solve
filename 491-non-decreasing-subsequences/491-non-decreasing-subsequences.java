class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        f(0, Integer.MIN_VALUE, new ArrayList<>(), set, nums);

        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> list : set) {
            ans.add(list);
        }

        return ans;
    }

    public void f(int idx, int prev, List<Integer> list, Set<List<Integer>> set, int[] nums) {
        if (idx >= nums.length) {
            if (list.size() >= 2) {
                set.add(new ArrayList<>(list));
            }

            return;
        }


        // take
        boolean taken = false;
        if (nums[idx] >= prev) {
            list.add(nums[idx]);
            taken = true;
            f(idx + 1, nums[idx], list, set, nums);
        }
        // not take
        if (taken) {
            list.remove(list.size() - 1);
        }
        f(idx + 1, prev, list, set, nums);
    }
}