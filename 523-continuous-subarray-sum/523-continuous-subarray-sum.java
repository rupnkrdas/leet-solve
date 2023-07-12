class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefix = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(); // remainder -> index
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            prefix += nums[i];
            int remainder = prefix % k;
            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) >= 2) return true;
                continue;
            }
            else {
                map.put(remainder, i);
            }
        }

        return false;
    }
}