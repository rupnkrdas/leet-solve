class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int singleNumber(int[] nums) {
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int num = e.getKey();
            int count = e.getValue();
            if (count == 1) return num;
        }

        return -1;
    }
}