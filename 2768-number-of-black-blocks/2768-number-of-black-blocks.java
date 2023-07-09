class Solution {
    public long[] countBlackBlocks(int n, int m, int[][] coordinates) {
        long[] ans = new long[5];
        Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        for (int[] c : coordinates) {
            int i = c[0];
            int j = c[1];
            Pair p;

            if (i - 1 >= 0 && j - 1 >= 0) {
                p = new Pair(i - 1, j - 1);
                map.put(p, map.getOrDefault(p, 0) + 1);
            }
            if (i - 1 >= 0 && j + 1 < m) {
                p = new Pair(i - 1, j);
                map.put(p, map.getOrDefault(p, 0) + 1);
            }
            if (i + 1 < n && j - 1 >= 0) {
                p = new Pair(i, j - 1);
                map.put(p, map.getOrDefault(p, 0) + 1);
            }
            if (i + 1 < n && j + 1 < m) {
                p = new Pair(i, j);
                map.put(p, map.getOrDefault(p, 0) + 1);
            }
        }

        long total = (long)(n - 1) * (long)(m - 1);
        for (int count : map.values()) {
            ans[count]++;
        }
        ans[0] = total - map.size();

        return ans;        
    } 
}