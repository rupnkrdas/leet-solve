class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        Map<Long, Integer> map = new HashMap<>();
        map.put((long)0, -1);
        long total = 0;
        for (int num : nums) {
            total += (long)num;
        }
        if (total == (long)x) return n;
        long k = total - x;
        int maxLen = 0;

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long)nums[i];

            long comp = sum - k;
            if (map.containsKey(comp)) {
                int l = map.get(comp);
                maxLen = Math.max(maxLen, i - l);
            }

            // System.out.println(map);
            map.put(sum, i);
        }

        return (maxLen != 0) ? n - maxLen : -1;
    }
}