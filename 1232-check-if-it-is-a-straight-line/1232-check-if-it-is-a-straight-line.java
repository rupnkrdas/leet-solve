class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int[][] arr = coordinates;
        int n = arr.length;
        int dy = arr[1][1] - arr[0][1];
        int dx = arr[1][0] - arr[0][0];

        for (int i = 2; i < n; i++) {
            int dy_i = arr[i][1] - arr[0][1];
            int dx_i = arr[i][0] - arr[0][0];

            if (dy * dx_i != dy_i * dx) return false;
        }

        return true;
    }
}