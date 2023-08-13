class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> set = new TreeSet<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            if (i - x >= 0) {
                set.add(nums.get(i-x));
            }

            int num = nums.get(i);
            Integer less = set.floor(num);
            if (less != null) {
                ans = Math.min(ans, num - (int)less);
            }
            Integer more = set.ceiling(num);
            if (more != null) {
                ans = Math.min(ans, (int)more - num);
            }
        }

        return ans;
    }
}