class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int start = nums[i];
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            if (nums[i] == start) {
                ans.add(Integer.toString(start));
            } else {
                ans.add(Integer.toString(start) + "->" + Integer.toString(nums[i]));
            }
        }

        return ans;
    }
}