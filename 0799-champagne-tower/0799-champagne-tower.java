class Solution {
    Map<String, Double> map = new HashMap<>();
    private double f(int i, int j, int poured) {
        if (i < 0 || j < 0 || j > i) return 0.0;
        if (i == 0 && j == 0) return poured;

        String key = Integer.toString(i) + "," + Integer.toString(j) + "," + Integer.toString(poured);
        if (map.containsKey(key)) return map.get(key);

        double up_left = (double)Math.max(0, (f(i - 1, j, poured) - 1)/2.0);
        double up_right = (double)Math.max(0, (f(i - 1, j - 1, poured) - 1)/2.0);

        double ans = up_left + up_right;

        map.put(key, ans);

        return ans;
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        return Math.min(1, f(query_row, query_glass, poured));
    }
}