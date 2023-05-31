class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int prefixSum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            if (prefixSum == k) count++;
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k).size();
            }
            // map.put(prefixSum, i);
            List<Integer> list = map.getOrDefault(prefixSum, new ArrayList<>());
            list.add(i);
            map.put(prefixSum, list);
        }

        return count;
    }
}