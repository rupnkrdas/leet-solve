class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> set_w = new TreeSet<>();
        Map<Integer, Integer> map_l = new TreeMap<>();
        for (int[] m: matches) {
            int winner = m[0];
            int loser = m[1];

            set_w.add(winner);
            map_l.put(loser, map_l.getOrDefault(loser, 0) + 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        for (int winner: set_w) {
            if (!map_l.containsKey(winner)) res.get(0).add(winner);
        }

        for (Map.Entry<Integer, Integer> e : map_l.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();

            if (val == 1) res.get(1).add(key);
        }

        return res;
    }
}