class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // (num -> freq)
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) > n/3) ans.add(key);
        }

        return ans;
    }
}