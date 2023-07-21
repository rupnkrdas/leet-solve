class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num - k, map.getOrDefault(num - k, 0) + 1);
            map.put(num + k + 1, map.getOrDefault(num + k + 1, 0) - 1);
        }

        int prefix = 0;
        int ans = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            prefix += e.getValue();
            ans = Math.max(ans, prefix);
        }

        return ans;
    }
}