class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (map.containsKey(num) && Math.abs(map.get(num) - i) <= k) return true;
            map.put(num, i);
        }

        return false;
    }
}