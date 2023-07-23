class Solution {
    private int MOD = (int)(1e9 + 7);
    Map<String, Long> map = new HashMap<>();
    private long f(long idx, long n, long x) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        
        if ((long)Math.pow(idx, x) > n) {
            return 0;
        }

        String key = Long.toString(idx) + "_" + Long.toString(n);
        if (map.containsKey(key)) return map.get(key);

        long take = f(idx + 1, n - (long)(Math.pow(idx, x)), x);
        long not_take = f(idx + 1, n, x);

        long ans = take + not_take;
        map.put(key, ans);
        return ans;
    }
    public int numberOfWays(int n, int x) {
        return (int)(f(1, (long)n, (long)x)%MOD);
    }
}