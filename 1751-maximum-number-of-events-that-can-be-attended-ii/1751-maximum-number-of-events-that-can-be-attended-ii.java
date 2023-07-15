class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    private int f(int idx, int k, int prev_end, int[][] events) {
        if (k == 0) return 0;
        if (idx == events.length) return 0;

        String key = Integer.toString(idx) + "," + Integer.toString(k) + "," + Integer.toString(prev_end);
        if (map.containsKey(key)) return map.get(key);

        int take = 0;
        int not_take = 0;

        if (events[idx][0] > prev_end) {
            take = events[idx][2] + f(idx + 1, k - 1, events[idx][1], events);
        }
        not_take = 0 + f(idx + 1, k, prev_end, events);

        int ans = Math.max(take, not_take);
        map.put(key, ans);
        return ans;
    }
    
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (e1, e2) -> Integer.compare(e1[1], e2[1]));
        return f(0, k, 0, events);
    }
}