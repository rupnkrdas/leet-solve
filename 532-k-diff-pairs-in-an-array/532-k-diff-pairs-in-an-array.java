class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        Map<Integer, Boolean> map = new HashMap<>();
        int count = 0;
        if (k == 0) {
            for (int i = 1; i < n; i++) {
                if (nums[i] == nums[i - 1]) {
                    count++;
                    while (i < n && nums[i] == nums[i - 1]) i++;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int p1 = k + nums[i];
                int p2 = nums[i] - k;

                if (p1 == p2) {
                    if (map.containsKey(p1)) count++;
                    continue;
                }

                if (map.containsKey(p1)) {
                    count++;
                }
                if (map.containsKey(p2)) {
                    count++;
                }

                map.put(nums[i], true);
            }
        }

        return count;
    }
}