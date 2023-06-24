class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int tallestBillboard(int[] rods) {
        int ans = f(0, rods, 0);

        return ans/2;
    }

    public int f(int idx, int[] nums, int diff) {
        if (idx == nums.length) {
            if (diff == 0) return 0;
            else return (int)(-1e9);
        }

        String key = Integer.toString(idx) + "," + Integer.toString(diff);
        if (map.containsKey(key)) return map.get(key);


        int take1 = nums[idx] + f(idx + 1, nums, diff + nums[idx]);
        int take2 = nums[idx] + f(idx + 1, nums, diff - nums[idx]);
        int notTake = f(idx + 1, nums, diff);

        int ans = Math.max(take1, Math.max(take2, notTake));
        map.put(key, ans);
        return ans;
    }
}