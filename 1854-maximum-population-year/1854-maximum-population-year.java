class Solution {
    public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] log : logs) {
            map.put(log[0], map.getOrDefault(log[0], 0) + 1);
            map.put(log[1], map.getOrDefault(log[1], 0) - 1);
        }

        int prefix = 0;
        int max_prefix = 0, ans = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            prefix += e.getValue();
            if (prefix > max_prefix) {
                max_prefix = prefix;
                ans = e.getKey();
            }
        }

        return ans;
    }
}