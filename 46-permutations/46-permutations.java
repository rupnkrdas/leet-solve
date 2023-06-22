import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, new ArrayList<>(), ans, 0);
        return ans;
    }

    public void solve(int[] nums, List<Integer> list, List<List<Integer>> ans, int mask) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (((1 << i) & mask) != 0) continue;
            list.add(nums[i]);
            solve(nums, list, ans, ((1 << i) | mask));
            list.remove(list.size() - 1);
        }
    }
}
