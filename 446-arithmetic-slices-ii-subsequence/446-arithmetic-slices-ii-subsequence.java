class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        Map<Long, Long> map[] = new Map[n]; // array of map
                                                  // map: (index) -> (count)
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
        }

        int result = 0;
        for (int index = 0; index < n; index++) {
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {
                long diff = (long)nums[index] - (long)nums[prevIndex];
                if (map[prevIndex].containsKey(diff)) {
                    long count = map[prevIndex].get(diff);
                    map[index].put(diff, map[index].getOrDefault(diff, (long)0) + count + 1);
                    result += count;
                } else {
                    map[index].put(diff, map[index].getOrDefault(diff, (long)0) + 1);
                }
            }
        }

        return result;
    }
}