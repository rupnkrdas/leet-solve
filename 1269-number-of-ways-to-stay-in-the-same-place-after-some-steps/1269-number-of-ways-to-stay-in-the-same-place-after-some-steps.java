class Solution {
    private int MOD = (int)(1e9 + 7);
    Map<String, Integer> map = new HashMap<>();
    private int f(int idx, int len, int steps) {
        if (steps == 0) {
            if (idx == 0) return 1;
            return 0;
        }
        if (steps < 0) return 0;

        String key = Integer.toString(idx) + "," + Integer.toString(steps);
        
        if (map.containsKey(key)) return map.get(key);

        int t = 0;
        if (idx + 1 < len) t = t%MOD + f(idx + 1, len, steps - 1)%MOD;
        if (idx - 1 >= 0) t = t%MOD + f(idx - 1, len, steps - 1)%MOD;
        t = t%MOD + f(idx, len, steps - 1)%MOD;

        map.put(key, t%MOD);
        return t%MOD;
    }
    public int numWays(int steps, int arrLen) {
        for (int i = 0; i < (int)(1e6 + 1); i++) {

        }
        return f(0, arrLen, steps);
    }
}