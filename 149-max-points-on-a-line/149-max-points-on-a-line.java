class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> map = new HashMap<>(); // (slope, count)
            for (int j = i + 1; j < n; j++) {
                double slope = calcSlope(points[i], points[j]);
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                maxi = Math.max(maxi, map.get(slope));
            }
        }

        return maxi + 1;
    } 

    public double calcSlope(int[] p1, int[] p2) {
        if (p1[1] == p2[1]) return 0;
        if (p1[0] == p2[0]) return Double.MAX_VALUE;
        else {
            return (double)(p2[1]-p1[1]) / (p2[0]-p1[0]);
        }
    }
}