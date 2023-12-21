class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> a[0] - b[0]);

        int maxi = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            maxi = Math.max(maxi, points[i][0] - points[i - 1][0]);
        }

        return maxi;
    }
}