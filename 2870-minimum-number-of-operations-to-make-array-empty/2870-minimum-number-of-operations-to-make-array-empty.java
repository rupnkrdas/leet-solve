class Solution {
    public int minOperations(int[] nums) {
        // 2 3 3 2 2 4 2 3 4
        // 2 2 2 2 -> 2
        // 3 3 3 -> 1
        // 4 4 -> 1

        // 2 1 2 2 3 3
        // 2 2 2 -> 1
        // 3 3 -> 1
        // 1 -> not possible 

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // System.out.println(map);

        int steps = 0;
        for (int val : map.values()) {
            if (val % 3 == 0) {
                steps += val/3;
                continue;
            }
            while (val >= 0) {
                if (val % 3 == 0) {
                    steps += val / 3;
                    break;
                } else {
                    steps++;
                    val -= 2;
                }
            }
            if (val < 0) return -1;
        }

        return steps;
    }
}