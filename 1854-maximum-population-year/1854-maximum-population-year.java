class Solution {
    public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] log : logs) {
            map.put(log[0], map.getOrDefault(log[0], 0) + 1);
            map.put(log[1], map.getOrDefault(log[1], 0) - 1);
        }

        int prefix = 0;
        int max_prefix = 0, ans = 0;
        for (int year = 1950; year <= 2050; year++) {
            prefix += map.getOrDefault(year, 0);
            if (prefix > max_prefix) {
                max_prefix = prefix;
                ans = year;
            }
        }

        return ans;
    }
}