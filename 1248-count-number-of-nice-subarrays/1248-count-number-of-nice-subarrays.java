class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        // convert odds to 1
        // convert evens to 0
        // question gets converted to find count of subarrays sum = k
        for (int i = 0; i < n; i++) {
            if ((nums[i]&1) > 0) nums[i] = 1;
            else nums[i] = 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            
            int need = sum - k;
            if (map.containsKey(need)) {
                count += map.get(need);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}