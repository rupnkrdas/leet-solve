class Solution {
    public int countPairs(List<List<Integer>> points, int k) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (List<Integer> c : points) {
            int x2 = c.get(0);
            int y2 = c.get(1);

            for (int i = 0; i <= k; i++) {
                int x1 = i ^ x2;
                int y1 = (k - i) ^ y2;

                String s1 = Integer.toString(x1) + "," + Integer.toString(y1);
                if (map.containsKey(s1)) {
                    count += map.get(s1);
                }
            }

            String s2 = Integer.toString(x2) + "," + Integer.toString(y2);
            map.put(s2, map.getOrDefault(s2, 0) + 1);

            // System.out.println(map);
        }

        return count;
    }
}