class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] r : ranges) {
            map.put(r[0], map.getOrDefault(r[0], 0) + 1);
            map.put(r[1] + 1, map.getOrDefault(r[1] + 1, 0) - 1);
        }

        int prefix = 0;
        for (int i = 1; i <= 50; i++) {
            prefix += map.getOrDefault(i, 0);
            if (left <= i && i <= right) {
                if (prefix == 0) return false;
            }
        }

        return true;
    }
}