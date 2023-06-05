class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        Arrays.sort(coordinates, (x, y) -> x[0] - y[0]);
        int[][] arr = coordinates;
        int n = arr.length;
        int num = 0;
        int den = 0;
        num = arr[1][1] - arr[0][1];
        den = arr[1][0] - arr[0][0];
        double slope = 0;
        if (den == 0) slope = (int)1e8;
        else slope = (double)num / den;

        boolean ans = true;

        for (int i = 1; i < n - 1; i++) {
            num = arr[i + 1][1] - arr[i][1];
            den = arr[i + 1][0] - arr[i][0];

            double temp = 0;
            if (den == 0) {
                temp = (int)1e8;
            } else {
                temp = (double)num / den;
            }

            if (temp != slope) return false;
        }


        return ans;
    }
}